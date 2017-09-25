package com.panding.main.perfecthttp;

import com.google.gson.JsonObject;

import com.panding.main.perfecthttp.response.Bd_Control_func;
import com.panding.main.perfecthttp.response.Bd_alarm_daily;
import com.panding.main.perfecthttp.response.Bd_alarm_mode_get;
import com.panding.main.perfecthttp.response.Bd_alarm_mode_put;
import com.panding.main.perfecthttp.response.Bd_client_control;
import com.panding.main.perfecthttp.response.Bd_driving_get;
import com.panding.main.perfecthttp.response.Bd_fence_del;
import com.panding.main.perfecthttp.response.Bd_fence_get;
import com.panding.main.perfecthttp.response.Bd_fence_post;
import com.panding.main.perfecthttp.response.Bd_fence_put;
import com.panding.main.perfecthttp.response.Bd_info_get;
import com.panding.main.perfecthttp.response.Bd_location_history;
import com.panding.main.perfecthttp.response.Bd_mileage_put;
import com.panding.main.perfecthttp.response.Bd_overspeed_get;
import com.panding.main.perfecthttp.response.Bd_overspeed_post;
import com.panding.main.perfecthttp.response.Bd_packages_get;
import com.panding.main.perfecthttp.response.Bd_password_put;
import com.panding.main.perfecthttp.response.Bd_sms_bind_put;
import com.panding.main.perfecthttp.response.Bd_sms_count_get;
import com.panding.main.perfecthttp.response.Bd_sms_psd_get;
import com.panding.main.perfecthttp.response.Bd_sms_send_get;
import com.panding.main.perfecthttp.response.Bd_url_get;
import com.panding.main.perfecthttp.response.H_Alarm_daily;
import com.panding.main.perfecthttp.response.Bd_location_last;
import com.panding.main.perfecthttp.response.Bd_obd;
import com.panding.main.perfecthttp.response.H_Client_control;
import com.panding.main.perfecthttp.response.H_Client_info;
import com.panding.main.perfecthttp.response.Control_func;
import com.panding.main.perfecthttp.response.H_Url_get;
import com.panding.main.perfecthttp.response.H_activate;
import com.panding.main.perfecthttp.response.H_driving_get;
import com.panding.main.perfecthttp.response.H_location_history_daily;
import com.panding.main.perfecthttp.response.H_mileage_put;
import com.panding.main.perfecthttp.response.H_obd_interval_post;
import com.panding.main.perfecthttp.response.H_overspeed_get;
import com.panding.main.perfecthttp.response.H_package_get;
import com.panding.main.perfecthttp.response.H_password_reset;
import com.panding.main.perfecthttp.response.H_pay_history;
import com.panding.main.perfecthttp.response.H_status;
import com.panding.main.perfecthttp.response.H_trial;
import com.panding.main.perfecthttp.response.Hfence_get;
import com.panding.main.perfecthttp.response.Hfence_getbind;
import com.panding.main.perfecthttp.response.Hfence_post;
import com.panding.main.perfecthttp.response.Hfence_postbind;
import com.panding.main.perfecthttp.response.H_Location_history;
import com.panding.main.perfecthttp.response.H_Location_last;
import com.panding.main.perfecthttp.response.Login_log_post;
import com.panding.main.perfecthttp.response.H_Obd_get;
import com.panding.main.perfecthttp.response.Mobile_palm;
import com.panding.main.perfecthttp.response.Operation_status;
import com.panding.main.perfecthttp.response.Operation_status_all;
import com.panding.main.perfecthttp.response.H_Alarm_mode_get;
import com.panding.main.perfecthttp.response.H_Alarm_mode_post;
import com.panding.main.perfecthttp.response.H_Overspeed_post;
import com.panding.main.perfecthttp.response.H_password_put;
import com.panding.main.perfecthttp.response.Pd_baoxian_get;
import com.panding.main.perfecthttp.response.Pd_login;
import com.panding.main.perfecthttp.response.Pd_login_check;
import com.panding.main.perfecthttp.response.Pd_login_post;
import com.panding.main.perfecthttp.response.Pd_remind_get;
import com.panding.main.perfecthttp.response.Pd_repair_get;
import com.panding.main.perfecthttp.response.Pd_vip_get;
import com.panding.main.perfecthttp.response.Poi_get;
import com.panding.main.perfecthttp.response.Poi_post;
import com.panding.main.perfecthttp.response.Hfence_delbind;
import com.panding.main.perfecthttp.response.Update_get;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2017/8/26.
 */

public interface PandingService {

    /**
     * 获得最后一条历史记录
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/location/last")
    Observable<H_Location_last> h_location_last(@Field("param") String param);

    /**
     *获得日报警信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/alarm/daily")
    Observable<H_Alarm_daily> h_alarm_daily(@Field("param") String param);

    /**
     *获得用户信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/client/info")
    Observable<H_Client_info> h_client_info(@Field("param") String param);

    /**
     * 获取历史轨迹信息:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/location/history")
    Observable<H_Location_history> h_location_history(@Field("param") String param);

    /**
     * 获取历史分段轨迹信息:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/location/history/daily")
    Observable<H_location_history_daily> h_location_history_daily(@Field("param") String param);

    /**
     * 获得远程控制功能列表
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("client/control/func")
    Observable<Control_func> control_func(@Field("param") String param);


    /**
     * 远程
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/client/control")
    Observable<H_Client_control> h_client_control(@Field("param") String param);

    /**
     * 获得收藏的poi数据
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("poi/get")
    Observable<Poi_get> poi_get(@Field("param") String param);

    /**
     * 修改poi是否收藏状态
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("poi/post")
    Observable<Poi_post> poi_post(@Field("param") String param);

    /**
     * {username:"sftest",password:"135"}(H平台组登录)
     {username:"粤kfc005",password:"000000"}(H平台个人用户登录)
     {username:"011000147",password:"123456"}(波导平台个人登录)
     {username:"江门总部",password:"123456"}(波导平台群用户登录)
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("login")
    Observable<JsonObject> login(@Field("param") String param);


    /**
     * 获得的电子围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/get")
    Observable<Hfence_get> hfence_get(@Field("param") String param);

    /**
     * h平台删除电子围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/del")
    Observable<Hfence_get> hfence_del(@Field("param") String param);

    /**
     * 删除绑定电子围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/bind/del")
    Observable<Hfence_delbind> hfence_delbind(@Field("param") String param);

    /**
     * 获取已绑定的电子围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/bind/get")
    Observable<Hfence_getbind> Hfence_getbind(@Field("param") String param);

    /**
     *H平台围栏绑定车辆或车组:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/bind/post")
    Observable<Hfence_postbind> hfence_postbind(@Field("param") String param);

    /**
     * 新增电子围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/fence/post")
    Observable<Hfence_post> hfence_post(@Field("param") String param);

    /**
     * 获取H平台车辆obd数据:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/obd/get")
    Observable<H_Obd_get> h_obd_get(@Field("param") String param);

    /**
     * 获取android更新信息
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @POST("update/get")
    Call<Update_get> update_get();

    /**
     * H平台激活用户:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/activate")
    Observable<H_activate> h_activate(@Field("param") String param);

    /**
     *H平台未激活试用:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/trial")
    Observable<H_trial> h_trial(@Field("param") String param);

    /**
     * H平台获取套餐:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/package/get")
    Observable<H_package_get> h_package_get(@Field("param") String param);

    /**
     *波导平台获取最后轨迹:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/location/last")
    Observable<Bd_location_last> bd_location_last(@Field("param") String param);

    /**
     * 波导平台获取OBD数据:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/obd")
    Observable<Bd_obd> bd_obd(@Field("param") String param);

    /**
     * H平台获取驾驶数据:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/driving/get")
    Observable<H_driving_get> h_driving_get(@Field("param") String param);

    /**
     * H平台获取交易数据:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/pay/history")
    Observable<H_pay_history> h_pay_history(@Field("param") String param);

    /**
     * H平台车辆状态:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/status")
    Observable<H_status> h_status(@Field("param") String param);


    /**
     * H平台远程控制指令下发状态:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/operation/status")
    Observable<Operation_status> operation_status(@Field("param") String param);

    /**
     * H平台远程控制指令所有的下发状态:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/operation/status/all")
    Observable<Operation_status_all> operation_status_all(@Field("param") String param);

    /**
     * 录入登录日志:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("login/log/post")
    Observable<Login_log_post> login_log_post(@Field("param") String param);

    /**
     * H平台修改里程:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/mileage/put")
    Observable<H_mileage_put> h_mileage_put(@Field("param") String param);

    /**
     * 修改密码
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/password/put")
    Observable<H_password_put> h_password_put(@Field("param") String param);

    /**
     * H平台超速报警:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/overspeed/post")
    Observable<H_Overspeed_post> h_overspeed_post(@Field("param") String param);

    /**
     * H平台设置超速报警模式:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/alarm/mode/post")
    Observable<H_Alarm_mode_post> h_alarm_mode_post(@Field("param") String param);


    /**
     * H平台获取超速报警模式:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/alarm/mode/get")
    Observable<H_Alarm_mode_get> h_alarm_mode_get(@Field("param") String param);

    /**
     * 获取H平台超速报警速度:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/overspeed/get")
    Observable<H_overspeed_get> h_overspeed_get(@Field("param") String param);

    /**
     * H平台打开OBD:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/obd/interval/post")
    Observable<H_obd_interval_post> h_obd_interval_post(@Field("param") String param);

    /**
     * 获取广告url:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/url/get")
    Observable<H_Url_get> h_url_get(@Field("param") String param);

    /**
     * bd历史轨迹
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/location/history")
    Observable<Bd_location_history> bd_location_history(@Field("param") String param);

    /**
     * bd用户信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/info/get")
    Observable<Bd_info_get> bd_info_get(@Field("param") String param);


    /**
     * 新增波导平台围栏
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/fence/post")
    Observable<Bd_fence_post> bd_fence_post(@Field("param") String param);

    /**
     * 获取波导平台围栏:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/fence/get")
    Observable<Bd_fence_get> bd_fence_get(@Field("param") String param);

    /**
     * 删除波导平台围栏:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/fence/del")
    Observable<Bd_fence_del> bd_fence_del(@Field("param") String param);

    /**
     * 修改波导平台围栏:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/fence/put")
    Observable<Bd_fence_put> bd_fence_put(@Field("param") String param);

    /**
     * 获取波导日报警:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/alarm/daily")
    Observable<Bd_alarm_daily> bd_alarm_daily(@Field("param") String param);

    /**
     * 波导远程控制
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/client/control")
    Observable<Bd_client_control> bd_client_control(@Field("param") String param);

    /**
     * 波导修改密码
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/password/put")
    Observable<Bd_password_put> bd_password_put(@Field("param") String param);


    /**
     * 波导获取套餐接口:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/packages/get")
    Observable<Bd_packages_get> bd_packages_get(@Field("param") String param);

    /**
     * 波导设置超速速度:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/overspeed/post")
    Observable<Bd_overspeed_post> bd_overspeed_post(@Field("param") String param);

    /**
     * 波导获取超速速度:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/overspeed/get")
    Observable<Bd_overspeed_get> bd_overspeed_get(@Field("param") String param);

    /**
     * 波导设置报警模式
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/alarm/mode/put")
    Observable<Bd_alarm_mode_put> bd_alarm_mode_put(@Field("param") String param);

    /**
     * 波导获取报警模式
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/alarm/mode/get")
    Observable<Bd_alarm_mode_get> bd_alarm_mode_get(@Field("param") String param);

    /**
     * 波导修改里程
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/mileage/put")
    Observable<Bd_mileage_put> bd_mileage_put(@Field("param") String param);

    /**
     * 波导获得远程控制功能列表
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("client/control/func")
    Observable<Bd_Control_func> bd_control_func(@Field("param") String param);

    /**
     * 波导发送短信剩余次数:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/sms/count/get")
    Observable<Bd_sms_count_get> bd_sms_count_get(@Field("param") String param);

    /**
     * 波导发送短信:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/sms/send/get")
    Observable<Bd_sms_send_get> bd_sms_send_get(@Field("param") String param);

    /**
     * 波导通过手机修改密码:
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/sms/psd/get")
    Observable<Bd_sms_psd_get> bd_sms_psd_get(@Field("param") String param);

    /**
     * 波导通过手机激活
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/sms/bind/put")
    Observable<Bd_sms_bind_put> bd_sms_bind_put(@Field("param") String param);

    /**
     * 波导驾驶统计
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/driving/get")
    Observable<Bd_driving_get> bd_driving_get(@Field("param") String param);

    /**
     * 波导获取广告
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("bd/url/get")
    Observable<Bd_url_get> bd_url_get(@Field("param") String param);

    /**
     *
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("mobile/palm")
    Observable<Mobile_palm> mobile_palm(@Field("param") String param);

    /**
     *
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("h/password/reset")
    Observable<H_password_reset> h_password_reset(@Field("param") String param);

    /**
     * 磐鼎登录
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/login")
    Observable<Pd_login> pd_login(@Field("param") String param);

    /**
     * 未验证用户跳去手机验证界面，先检查手机有效性
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/login/check")
    Observable<Pd_login_check> pd_login_check(@Field("param") String param);

    /**
     * 通过验证后,发送验证码验证,然后调用改接口修改"手机通过验证"属性
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/login/post")
    Observable<Pd_login_post> pd_login_post(@Field("param") String param);

    /**
     * 会员信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/vip/get")
    Observable<Pd_vip_get> pd_vip_get(@Field("param") String param);

    /**
     * 保险信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/baoxian/get")
    Observable<Pd_baoxian_get> pd_baoxian_get(@Field("param") String param);

    /**
     * 提醒信息
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/remind/get")
    Observable<Pd_remind_get> pd_remind_get(@Field("param") String param);

    /**
     * 维修记录(最后一条)
     * @param param
     * @return
     */
    @Headers({
            "api-version:1"
    })
    @FormUrlEncoded
    @POST("pd/repair/get")
    Observable<Pd_repair_get> pd_repair_get(@Field("param") String param);




}
