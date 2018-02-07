package com.daoshan.school.utils;



/**
 * @author 苏先华
 * 
 * @update 朱同 2017/12/15
 * 
 * 常量类 见文知意
 *
 */
public class ConstantConfig {
    
    /**
     * 前端请求(回复)常量，tableId 桌号
     */
    public final static String TABLE_ID = "tableId";
    /**
     * 前端请求(回复)常量，moneyTotal 账单总价
     */
    public final static String MONEY_TOTAL = "moneyTotal";
    /**
     * 前端请求(回复)常量，food 食品
     */
    public final static String FOOD = "food";
    /**
     * 前端请求(回复)常量，foodId 食品表的主键
     */
    public final static String FOOD_ID = "foodId";
    /**
     * 前端请求(回复)常量，foodName 食品名称
     */
    public final static String FOOD_NAME = "foodName";
    /**
     * 前端请求(回复)常量，foodNumber 食品
     */
    public final static String FOOD_NUMBER = "foodNumber";
    /**
     * 前端请求(回复)常量，foodPrize 食品单价
     */
    public final static String FOOD_PRIZE = "foodPrize";
    /**
     * 前端请求(回复)常量，foodTotalPrize 一次账单的单个食品总价
     */
    public final static String FOOD_TOTAL_PRIZE = "foodTotalPrize";
    /**
     * 前端请求(回复)常量，state 账单状态编号
     */
    public final static String BILL_STATE = "state";
    /**
     * 前端请求(回复)常量，stateText 帐单状态编号对应显示值
     */
    public final static String BILL_STATE_TEXT = "stateText";
    /**
     * 前端请求(回复)常量，billId 账单编号
     */
    public final static String BILL_ID = "billId";
    /**
     * 前端请求(回复)常量，0 账单编号0 代表已下单 
     */
    public final static byte BILL_STATE_PLACE_ORDER = 0;
    /**
     * 前端请求(回复)常量，1 账单编号1 代表待付款 
     */
    public final static byte BILL_STATE_LOCK_BILL = 1;
    /**
     * 前端请求(回复)常量，2 账单编号2 代表已付款 
     */
    public final static byte BILL_STATE_ACCOUNT_PAID = 2;
    /**
     * 前端请求(回复)常量，已下单  对应状态编号0 
     */
    public final static String BILL_STATE_PLACE_ORDER_TEXT = "已下单";
    /**
     * 前端请求(回复)常量，待付款  对应状态编号1 
     */
    public final static String BILL_STATE_LOCK_BILL_TEXT = "待付款";
    /**
     * 前端请求(回复)常量，已付款  对应状态编号2 
     */
    public final static String BILL_STATE_ACCOUNT_PAID_TEXT = "已付款";
    /**
     * 前端请求(回复)常量，OrderDetail 订单细节
     */
    public final static String ORDER_DETAIL = "OrderDetail";
    /**
     * 前端请求(回复)常量，yyyy-MM-dd HH:mm:ss 时间编码格式
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 前端请求(回复)常量，N 删除标记，表示未删除
     */
    public final static String DELETE_FLAG_FALSE = "N";
    /**
     * 前端请求(回复)常量，0 表示返回数据异常
     */
    public final static String RETURN_STATE_EXCEPTION = "0";
    /**
     * 前端请求(回复)常量，0 表示请求有误
     */
    public final static String RESPONSE_ERROR = "请求有误！";
    /**
     * 默认用户名
     */
    public final static String DEFAULT_USER = "管理员";
    /**
     * 前端请求(回复)常量，SUCCESS 表示请求成功
     */
    public final static String RESULT_SUCCESS = "SUCCESS";
    /**
     * 前端请求(回复)常量，FAILURE 表示请求成功
     */
    public final static String RESULT_FAILURE ="FAILURE";
    
    /**
     * 前端请求(回复)常量，系统异常  表示出现了异常
     */
    public final static String SystemException ="FAILURE";
}
