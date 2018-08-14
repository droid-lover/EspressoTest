package com.jarvis.espressotest.my_tests;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.matcher.IntentMatchers;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jarvis.espressotest.MainActivity;
import com.jarvis.espressotest.R;

import org.hamcrest.core.AllOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;


@RunWith(AndroidJUnit4.class)
public class IntentTest {

    @Rule
    public IntentsTestRule<MainActivity> mainActivityActivityTestRule =
            new IntentsTestRule<MainActivity>(MainActivity.class);

    @Test
    public void testingIntent() {

        Espresso.onView(ViewMatchers.withId(R.id.button2)).perform(ViewActions.click());


        Intents.intended(allOf(IntentMatchers.toPackage("com.jarvis.espressotest")));

    }
}
