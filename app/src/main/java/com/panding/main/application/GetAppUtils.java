package com.panding.main.application;

import android.text.TextUtils;


import com.panding.main.perfecthttp.response.Login_h_group;
import com.panding.main.perfecthttp.response.Login_h_single;

import java.util.List;

/** 获得存放在application中重要的参数
 * Created by Administrator on 2017/6/14.
 */

public class GetAppUtils {

    public static String getObjectID(MapKeyApplication application){
        return application.getLoginHSingle().getObjectId();
    }

    public static String getUserID(MapKeyApplication application) {
        String userID = "";
        //个人用户
        if (application.getVehiclegroup() == 0) {
            userID = application.getLoginHSingle().getUserID();
        }
        //组用户登录，循环获得
        else if(application.getVehiclegroup() ==1){
            userID = application.getLoginhgroup().getUserID();
        }

        return userID;
    }


    public static String getGroupName(MapKeyApplication application){
        String result = "";
        Login_h_single loginHSingle = application.getLoginHSingle();
        if (application.getVehiclegroup() == 0) {
            result ="侍卫长";
        } else if (application.getVehiclegroup() == 1) {
            Login_h_group loginhgroup = application.getLoginhgroup();
            List<Login_h_group.GroupListBean> groupList = loginhgroup.getGroupList();
            for (Login_h_group.GroupListBean group : groupList) {
                String groupName = group.getGroupName();
                for (Login_h_group.GroupListBean.CarListBean car : group.getCarList()) {
                    //找到该分组组名
                    if (TextUtils.equals(car.getObjectId(), loginHSingle.getObjectId())) {
                        result = groupName;
                    }
                }

            }
        }
        return result;
    }

    /**
     * 获得用户类型
     * @param application
     * @return
     */
    public static String getVehicleType(MapKeyApplication application){
        String result = "";
        Login_h_single loginHSingle = application.getLoginHSingle();
        if (application.getVehiclegroup() == 0) {
            result = loginHSingle.getVehicleType();
        } else if (application.getVehiclegroup() == 1) {
            Login_h_group loginhgroup = application.getLoginhgroup();
            List<Login_h_group.GroupListBean> groupList = loginhgroup.getGroupList();
            for (Login_h_group.GroupListBean group : groupList) {
                for (Login_h_group.GroupListBean.CarListBean car : group.getCarList()) {
                    //找到该分组组名
                    if (TextUtils.equals(car.getObjectId(), loginHSingle.getObjectId())) {
                        result = car.getVehType();
                    }
                }

            }
        }
        return result;
    }

    /**
     * 获得终端号
     * @param application
     * @return
     */
    public static String getTermanalNum(MapKeyApplication application){
        String result = "";
        Login_h_single loginHSingle = application.getLoginHSingle();
        if (application.getVehiclegroup() == 0) {
            result = loginHSingle.getTerminalNum();
        } else if (application.getVehiclegroup() == 1) {
            Login_h_group loginhgroup = application.getLoginhgroup();
            List<Login_h_group.GroupListBean> groupList = loginhgroup.getGroupList();
            for (Login_h_group.GroupListBean group : groupList) {
                for (Login_h_group.GroupListBean.CarListBean car : group.getCarList()) {
                    //找到该分组组名
                    if (TextUtils.equals(car.getObjectId(), loginHSingle.getObjectId())) {
                        result = car.getTerminalNum();
                    }
                }

            }
        }
        else if(application.getVehiclegroup() == 2){
            result = application.getLoginBdSingle().getTerminalNum();
        }
        return result;
    }

    /**
     * 获得device_code
     * @param application
     * @return
     */
    public static String getDeviceCode(MapKeyApplication application){
        String result = "";
        Login_h_single loginHSingle = application.getLoginHSingle();
        if (application.getVehiclegroup() == 0) {
            result = loginHSingle.getDeviceCode();
        } else if (application.getVehiclegroup() == 1) {
            Login_h_group loginhgroup = application.getLoginhgroup();
            List<Login_h_group.GroupListBean> groupList = loginhgroup.getGroupList();
            for (Login_h_group.GroupListBean group : groupList) {
                for (Login_h_group.GroupListBean.CarListBean car : group.getCarList()) {
                    //找到DeviceCode
                    if (TextUtils.equals(car.getObjectId(), loginHSingle.getObjectId())) {
                        result = car.getDeviceCode();
                    }
                }

            }
        }
        return result;
    }

    /**
     * 获得车牌号
     * @param application
     * @return
     */
    public static String getCarnum(MapKeyApplication application){
        String result = "";
        Login_h_single loginHSingle = application.getLoginHSingle();
        if (application.getVehiclegroup() == 0) {
            result = loginHSingle.getCarLicenseNum();
        } else if (application.getVehiclegroup() == 1) {
            Login_h_group loginhgroup = application.getLoginhgroup();
            List<Login_h_group.GroupListBean> groupList = loginhgroup.getGroupList();
            for (Login_h_group.GroupListBean group : groupList) {
                for (Login_h_group.GroupListBean.CarListBean car : group.getCarList()) {
                    //找到DeviceCode
                    if (TextUtils.equals(car.getObjectId(), loginHSingle.getObjectId())) {
                        result = car.getCarLicenseNum();
                    }
                }

            }
        }else if(application.getVehiclegroup() == 2){
            result = application.getLoginBdSingle().getCname();

        }else if(application.getVehiclegroup()==3){

        }
        return result;
    }

}
