package com.eight.mobile.test;

import com.eight.mobile.api.Config;
import com.eight.mobile.base.PageContext;
import com.eight.mobile.setting.Configurator;
import com.eight.mobile.utils.UiObject;
import com.eight.mobile.utils.Utils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by houshuo on 16/11/23.
 * 为了兼容华为手机管家弹窗
 */
public class TestSetting extends TestCaseBase {
    private By ALLOW = By.id("com.huawei.systemmanager:id/btn_allow");
    private By NEXT = By.id("com.zhubajie.client:id/system_dialog_btn2");
    private By ALL_ALLOW = By.id("com.android.packageinstaller:id/permission_allow_button");

    @Test
    public void testDemo() throws InterruptedException, IOException {
        clearGrantRightDialog();
        Thread.sleep(30000);
        UiObject.getAppiumDriver().findElementByName("下次再说");
    }

    private void clearGrantRightDialog() throws IOException {
        for (int i = 0; i < 3; i++) {
            if (UiObject.searchFor(ALLOW)) {
                UiObject.waitFor(ALLOW).click();
            } else {
                System.out.println();
                break;
            }
        }
        if (UiObject.searchFor(ALL_ALLOW)) {
            UiObject.waitFor(ALL_ALLOW).click();
        }

    }
}
