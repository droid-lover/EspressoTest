package com.jarvis.espressotest.my_tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jarvis.espressotest.LoginActivity;
import com.jarvis.espressotest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Test
    public void loginButtonClicked_WentToMainActivity() {
        String email = "username@email.com";
        String password = "password";

        //type in email
        onView(withId(R.id.et_email_id)).perform(typeText(email), closeSoftKeyboard());

        //type in password
        onView(withId(R.id.et_password)).perform(typeText(password), closeSoftKeyboard());

        //click on login button
        onView(withId(R.id.btn_login)).perform(click());

//        //verify that success screen shows
        String successValue = InstrumentationRegistry.getTargetContext().getString(R.string.welcome_success);
        onView(withText(successValue)).check(matches(isDisplayed()));
    }

    @Test
    public void buttonClicked(){
        onView(withId(R.id.btn_login)).perform(click());
    }
}
