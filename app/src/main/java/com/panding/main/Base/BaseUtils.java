package com.panding.main.Base;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.widget.Toast;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.panding.main.perfecthttp.response.Update_get;


import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.baidu.mapapi.utils.CoordinateConverter.CoordType.COMMON;
import static com.baidu.mapapi.utils.CoordinateConverter.CoordType.GPS;

/**
 * Created by Administrator on 2017/5/31.
 */

public class BaseUtils {


    /**
     * 将gps坐标转换成百度坐标
     *
     * @param Lat
     * @param Lon
     * @return
     */
    public static LatLng gpsTranstoBaidu(double Lat, double Lon) {
        // 获取gps经纬度
        LatLng gpsPoint = new LatLng(Lat, Lon);
        // LatLng gpsPoint = new LatLng(39.963175, 116.400244);

        // 将GPS设备采集的原始GPS坐标转换成百度坐标
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(GPS);
        // sourceLatLng待转换坐标
        converter.coord(gpsPoint);
        LatLng bauduPoint = converter.convert();
        return bauduPoint;
    }


    public static LatLng MarsTransToBaidu(double Lat, double Lon){
        LatLng sourceLatLng = new LatLng(Lat, Lon);

        CoordinateConverter converter  = new CoordinateConverter();
        converter.from(COMMON);
// sourceLatLng待转换坐标
        converter.coord(sourceLatLng);
        LatLng desLatLng = converter.convert();
        return desLatLng;
    }
    /**
     * 正则表达式匹配判断
     * @param patternStr 匹配规则
     * @param input 需要做匹配操作的字符串
     * @return true if matched, else false
     */
    public static boolean isMatchered(String patternStr, CharSequence input) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return true;
        }
        return false;
    }



    public static String getIPAddress(Context context) {
        NetworkInfo info = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }

    /**
     * 根据传进来的半径获得缩放级别
     * @param radius
     * @return
     */
    public static int getZoomLevel(double radius){
        int zooms[] = {5,10,20,50,100,200,500,1000,2000,5000,10000,20000,25000,50000,100000,200000,500000,1000000,2000000};
        int levels[] = {21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3};
        double distance = radius * 2;
        int resultLevel = 20;
        for(int i=0;i<zooms.length;i++){
           if(zooms[i]-distance>=0){
               resultLevel = levels[i];
               break;
           }
        }
        return  (resultLevel+3>21)?21:resultLevel+3;   //之所以会多3，是因为地图范围常常是比例尺距离的10倍以上。所以级别会增加3。
    }



    static double x_PI = 3.14159265358979324 * 3000.0 / 180.0;
    static double PI = 3.1415926535897932384626;
    static double a = 6378245.0;
    static double ee = 0.00669342162296594323;

    /**
     * 百度坐标系 (BD-09) 与 火星坐标系 (GCJ-02)的转换 即 百度 转 谷歌、高德
     *
     * @returns {*[]}
     */
    public static LatLng baiduToGcj02(LatLng baiduPoi) {
        double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
        double x = baiduPoi.longitude - 0.0065;
        double y = baiduPoi.latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        double gg_lng = z * Math.cos(theta);
        double gg_lat = z * Math.sin(theta);
        LatLng baiduP = new LatLng(gg_lat, gg_lng);
        return baiduP;
    }

    /**
     * GCJ02 转换为 WGS84
     * @returns {*[]}
     */
    public static LatLng gcj02ToWgs84(LatLng gcjPoi) {

        // 如果在国外，则默认不进行转换
        if (outOfChina(gcjPoi.latitude, gcjPoi.longitude)) {
            LatLng Wgs84P = new LatLng(gcjPoi.latitude, gcjPoi.longitude);
            return (Wgs84P);
        }

        double lat = gcjPoi.latitude;
        double lng = gcjPoi.longitude;
        double dlat = transformlat(lng - 105.0, lat - 35.0);
        double dlng = transformlng(lng - 105.0, lat - 35.0);
        double radlat = lat / 180.0 * PI;
        double magic = Math.sin(radlat);
        magic = 1 - ee * magic * magic;
        double sqrtmagic = Math.sqrt(magic);
        dlat = (dlat * 180.0) / ((a * (1 - ee)) / (magic * sqrtmagic) * PI);
        dlng = (dlng * 180.0) / (a / sqrtmagic * Math.cos(radlat) * PI);
        double mglat = lat + dlat;
        double mglng = lng + dlng;
        LatLng Wgs84P = new LatLng(lat * 2 - mglat, lng * 2 - mglng);
        return Wgs84P;

    }

    private static Double transformlat(Double x, Double y) {
        // double lng=trLatLon.longitude;
        // double lat=trLatLon.latitude;
        Double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * PI) + 40.0 * Math.sin(y / 3.0 * PI)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * PI) + 320 * Math.sin(y * PI / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    private static Double transformlng(Double x, Double y) {
        Double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * PI) + 20.0 * Math.sin(2.0 * x * PI)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * PI) + 40.0 * Math.sin(x / 3.0 * PI)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * PI) + 300.0 * Math.sin(x / 30.0 * PI)) * 2.0 / 3.0;
        return ret;
    }

    public static boolean outOfChina(double lat, double lon) {
        if (lon < 72.004 || lon > 137.8347)
            return true;
        if (lat < 0.8293 || lat > 55.8271)
            return true;
        return false;
    }

}
