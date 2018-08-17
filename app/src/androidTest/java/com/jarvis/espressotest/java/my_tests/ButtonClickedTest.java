package com.jarvis.espressotest.java.my_tests;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jarvis.espressotest.MainActivity;
import com.jarvis.espressotest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ButtonClickedTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonClicked() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.button1)).perform(ViewActions.click());
    }

}
