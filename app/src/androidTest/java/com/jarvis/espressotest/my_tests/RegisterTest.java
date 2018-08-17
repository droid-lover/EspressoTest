package com.jarvis.espressotest.my_tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jarvis.espressotest.R;
import com.jarvis.espressotest.RegisterActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {

    @Rule
    public ActivityTestRule<RegisterActivity> mActivityActivityTestRule =
            new ActivityTestRule<RegisterActivity>(RegisterActivity.class);

    @Test
    public void signupButtonClicked_WentToMainActivity() {

        String name = "Thor Asgardian";
        String email = "thor@asgardian.com";
        String password = "powerful_avenger";

        //type in name
        onView(withId(R.id.et_name_in_reg)).perform(typeText(name));
        //type in email
        onView(withId(R.id.et_email_in_reg)).perform(typeText(email));
        //type in password
        onView(withId(R.id.et_password_in_reg)).perform(typeText(password));

        //click on login button
        onView(withId(R.id.button_sign_up)).perform(click());

        //verify that success screen shows
        String successValue = InstrumentationRegistry.getTargetContext().getString(R.string.welcome_success);
        onView(withText(successValue)).check(matches(isDisplayed()));

    }
}
