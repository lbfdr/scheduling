package com.cn.topsroboteer.scheduling.utils.result;




public class BaseAction {
    public BaseAction() {
    }

    public <P> PageInfo<P> getPageInfo(PageRequest pageRequest) {
        return PageUtil.getPageInfo(pageRequest);
    }

    public <P> PageInfo<P> getPageInfo(long current, long size) {
        return PageUtil.getPageInfo(current, size);
    }

    public <P> Page<P> getPage(PageRequest pageRequest) {
        return new Page(pageRequest.getCurrent(), pageRequest.getSize());
    }

    public <P> Page<P> getPage(long current, long size) {
        return new Page(current, size);
    }
}
