package com.eight.mobile.utils;

import com.eight.mobile.setting.Configurator;
import io.appium.java_client.AppiumDriver;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Set;

public class Utils {
    private static String SQL_URL = "172.20.20.3:3306";
    private static String SQL_NAME = "root";
    private static String SQL_PASSWORD = "zhubajie";

    public static String formate(float num) {
        int a = (int) (num);
        if (num / a == 1) {
            String str = String.valueOf(a);
            return str;
        }
        DecimalFormat df = new DecimalFormat("#.##");
        float get_double = Float.parseFloat(df.format(num));
        String str = String.valueOf(get_double);
        return str;
    }

    public static String getContext() {
        Set<String> contextHandles = Configurator.instance().getAppiumDriver().getContextHandles();
        for (String contextName : contextHandles) {
            System.out.println(contextName);
            if (!contextName.equals("NATIVE_APP")) {
                return contextName;
            }
        }
        return null;
    }

    /**
     * 获取注册验证码
     *
     * @param mobile
     * @return
     * @throws SQLException
     */
    public static String getRegisterVerificatonCode(String mobile) throws SQLException {
        //查询验证码sql
        String sql = "SELECT verification_code FROM zhubajie_member.mb_verification WHERE verification_data = " + mobile + " ORDER BY create_time DESC LIMIT 1";
        String key = "verification_code";

        return querySql(sql, key);
    }

    /**
     * @param sql sql语句
     * @param key 数据库返回结果关键字
     * @return
     * @throws SQLException
     */
    public static String querySql(String sql, String key) throws SQLException {
        //连接数据库
        MySqlUtil mySql = new MySqlUtil(SQL_URL, SQL_NAME, SQL_PASSWORD);
        mySql.Connect();

        //执行查询
        ResultSet result = mySql.Query(sql);
        //返回查询数据
        String verificationCode = null;
        while (result.next()) {
            verificationCode = result.getString(key);
        }
        return verificationCode;
    }

    public static void scrollUp() {
        AppiumDriver driver = Configurator.instance().getAppiumDriver();
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        driver.swipe(width / 2, height * 3 / 4, width / 2, height / 4, 1000);
    }

    public static void goBack() {
        if ("Android".equalsIgnoreCase(Configurator.instance().getParamters().get(Configurator.PLATFORM_NAME))) {
            UiObject.getAppiumDriver().sendKeyEvent(4);
        }
    }

//    public static String isAndroid(String adb) throws IOException, InterruptedException {
//        Runtime run = Runtime.getRuntime(); // (adb.exe安装路径)
//        System.out.println("---------------------------------run");
//        Process p = run.exec(adb);
//        System.out.println("---------------------------------run");
//        BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String inline;
//        while ((inline = br.readLine()) != null) {
//            System.out.println(inline);
//            if (inline.contains("error")) {
//                return "Ios";
//            }
//        }
//        br.close();
//        return "Android";
//
//    }
    public static void  test(){
        try {

            Process process = Runtime.getRuntime().exec("adb shell");  //adb shell

            final BufferedWriter outputStream = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            final BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));

            //这里一定要注意错误流的读取，不然很容易阻塞，得不到你想要的结果，

            final  BufferedReader  errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            new Thread(new Runnable() {

                String line;



                public void run() {

                    System.out.println("listener started");

                    try {

                        while((line=inputStream.readLine()) != null) {
                            System.out.println("readline");
                            System.out.println(line);
                        }

                    } catch (IOException e) {

                        //e.printStackTrace();

                    }

                }

            }).start();

            new Thread(new Runnable() {

                final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



                public void run() {

                    System.out.println("writer started");

                    String line;

                    try {

                        while ((line =br.readLine()) != null) {

                            System.out.println(line);
                            outputStream.write(line + "\r\n");
                            outputStream.flush();

                        }

                    } catch (IOException e) {

                        //e.printStackTrace();

                    }

                }

            }).start();

            int i = process.waitFor();

            System.out.println("i=" + i);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
    public static String runCommand(String command) {
        BufferedReader br2 = null;
        String str = "";
        String line = null;
        InputStream is = null;
        InputStreamReader isReader = null;
        try {
            Process proc = Runtime.getRuntime().exec(command);
            is = proc.getInputStream();
            isReader = new InputStreamReader(is, "utf-8");
            br2 = new BufferedReader(isReader);

            while ((line = br2.readLine()) != null) {
                str = str + line;
            }
            return str;
        } catch (IOException e) {
            return line;
        } finally {
            if (isReader != null) {
                try {
                    isReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                }
            }

            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                }
            }

            if (br2 != null) {
                try {
                    br2.close();
                } catch (IOException e) {
                    // TODO
                }
            }
        }

    }

}


