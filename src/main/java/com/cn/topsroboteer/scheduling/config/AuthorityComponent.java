//package com.cn.topsroboteer.scheduling.config;
//
//import cn.hutool.core.collection.CollectionUtil;
//import com.cn.topsroboteer.scheduling.administration.userManage.model.dto.BaseDTO;
//import com.cn.topsroboteer.scheduling.administration.userManage.service.AdminUserService;
//import com.cn.topsroboteer.scheduling.exception.ForBiddenException;
//import com.cn.topsroboteer.scheduling.exception.InformationErrorException;
//import com.cn.topsroboteer.scheduling.exception.UniversalException;
//import com.cn.topsroboteer.scheduling.utils.Constant;
//import org.apache.commons.lang.StringUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
///**
// * 权限控制
// *
// * @author Dong.w
// */
//@Aspect
//@Component
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//public class AuthorityComponent {
//
//    @Autowired
//    private AdminUserService adminUserService;
//
//    private static final List<String> AUTH_LIST = Arrays.asList("adminLogin");
//
//
//    @Pointcut("execution(* com.cn.topsroboteer.scheduling.administration.userManage.controller.*.*(..))")
//    public void adminPointCut() {
//    }
//    @Pointcut("execution(* com.cn.topsroboteer.scheduling.administration.projectManagement.controller.*.*(..))")
//    public void adminProjectPointCut() {
//    }
//
////    @Pointcut("execution(* com.mongolia.controller.app.*.*(..))")
////    public void appPointCut() {
////    }
////
////    @Pointcut("execution(* com.mongolia.controller.advert.*.*(..))")
////    public void appUpAdvert() {
////    }
//
////    @Around("appUpAdvert()")
////    public Object appUpAdvertControl(ProceedingJoinPoint joinPoint) throws Throwable {
////        Object[] args = joinPoint.getArgs();
////
////        return joinPoint.proceed(args);
////
//////        BaseDTO data = null;
//////        for (Object arg : args) {
//////            if (arg instanceof BaseDTO) {
//////                data = (BaseDTO) arg;
//////            }
//////        }
//////        String functionName = joinPoint.getSignature().getName();
//////        String token = "";
//////        if (Objects.nonNull(data) && StringUtils.isEmpty(data.getToken())) {
//////            throw new ForBiddenException();
//////        } else if (Objects.nonNull(data)) {
//////            token = data.getToken();
//////        }
//////        if (isRelease(token, functionName, 0)) {
//////            return joinPoint.proceed(args);
//////        } else {
//////            throw new ForBiddenException();
//////        }
////    }
//
//
////    @Around("appPointCut()")
////    public Object appAuthorityControl(ProceedingJoinPoint joinPoint) throws Throwable {
////        Object[] args = joinPoint.getArgs();
////        BaseDTO data = null;
////        for (Object arg : args) {
////            if (arg instanceof BaseDTO) {
////                data = (BaseDTO) arg;
////            }
////        }
////        String functionName = joinPoint.getSignature().getName();
////        String token = "";
////        if (Objects.nonNull(data) && StringUtils.isEmpty(data.getToken())) {
////            throw new ForBiddenException();
////        } else if (Objects.nonNull(data)) {
////            token = data.getToken();
////        }
////        if (isRelease(token, functionName, 0)) {
////            return joinPoint.proceed(args);
////        } else {
////            throw new ForBiddenException();
////        }
////    }
//
//    @Around("adminPointCut()")
//    public Object adminAuthorityControl(ProceedingJoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        BaseDTO data = null;
//        for (Object arg : args) {
//            if (arg instanceof BaseDTO) {
//                data = (BaseDTO) arg;
//            }
//        }
//        try {
//            String functionName = joinPoint.getSignature().getName();
//            String token = "";
//            if (Objects.nonNull(data) && StringUtils.isEmpty(data.getToken())) {
//                throw new ForBiddenException();
//            } else if (Objects.nonNull(data)) {
//                token = data.getToken();
//            }
//            if (isRelease(token, functionName, 1)) {
//                return joinPoint.proceed(args);
//            } else {
//                throw new ForBiddenException();
//            }
//        } catch (UniversalException | ForBiddenException | InformationErrorException e) {
//            throw e;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return Constant.STATE_FAILURE;
//        }
//    }
//
//    @Around("adminProjectPointCut()")
//    public Object adminProjectAuthorityControl(ProceedingJoinPoint joinPoint) {
//        Object[] args = joinPoint.getArgs();
//        BaseDTO data = null;
//        for (Object arg : args) {
//            if (arg instanceof BaseDTO) {
//                data = (BaseDTO) arg;
//            }
//        }
//        try {
//            String functionName = joinPoint.getSignature().getName();
//            String token = "";
//            if (Objects.nonNull(data) && StringUtils.isEmpty(data.getToken())) {
//                throw new ForBiddenException();
//            } else if (Objects.nonNull(data)) {
//                token = data.getToken();
//            }
//            if (isRelease(token, functionName, 1)) {
//                return joinPoint.proceed(args);
//            } else {
//                throw new ForBiddenException();
//            }
//        } catch (UniversalException | ForBiddenException | InformationErrorException e) {
//            throw e;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            return Constant.STATE_FAILURE;
//        }
//    }
//
//    private boolean isRelease(String token, String method, int flag) {
//
//
//        return CollectionUtil.contains(AUTH_LIST, method)
//                    || adminUserService.adminAuthorization(token);
//
//    }
//
//}
