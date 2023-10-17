package com.cn.topsroboteer.scheduling.utils.result;




import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageUtil {
    public PageUtil() {
    }

    public static <P> PageInfo<P> getPageInfo(PageRequest pageRequest) {
        if (pageRequest == null) {
            return null;
        } else {
            PageInfo<P> page = new PageInfo(pageRequest.getCurrent(), pageRequest.getSize());
            List<OrderItem> orders = new ArrayList();
            if (!CollectionUtils.isEmpty(pageRequest.getAscOrders())) {
                pageRequest.getAscOrders().forEach((order) -> {
                    orders.add(OrderItem.asc(order));
                });
            }

            if (!CollectionUtils.isEmpty(pageRequest.getDescOrders())) {
                pageRequest.getDescOrders().forEach((order) -> {
                    orders.add(OrderItem.desc(order));
                });
            }

            page.setOrders(orders);
            return page;
        }
    }

    public static <P> PageInfo<P> getPageInfo(long current, long size) {
        return new PageInfo(current, size);
    }

    public static <P> PageInfo<P> getLogicalPageInfo(PageInfo<P> pageInfo, List<P> list) {
        pageInfo.setRecords(Collections.emptyList());
        if (list != null && list.size() != 0) {
            int totalCount = list.size();
            int size = (int) pageInfo.getSize();
            int m = totalCount % size;
            int currentPage = (int) pageInfo.getCurrent();
            int pageCount;
            if (m > 0) {
                pageCount = totalCount / size + 1;
            } else {
                pageCount = totalCount / size;
            }


            currentPage = currentPage <= 0 ? 1 : currentPage;
            currentPage = currentPage > pageCount ? pageCount : currentPage;
            int fromIndex = (currentPage - 1) * size;
            int toIndex;
            if (currentPage == pageCount) {
                toIndex = list.size();
            } else {
                toIndex = currentPage * size;
            }

            pageInfo.setTotal((long) totalCount);
            pageInfo.setRecords(list.subList(fromIndex, toIndex));
        }

        return pageInfo;
    }
}
