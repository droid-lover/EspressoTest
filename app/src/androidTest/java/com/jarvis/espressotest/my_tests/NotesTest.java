package com.jarvis.espressotest.notes;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.ListView;

import com.jarvis.espressotest.NotesActivity;
import com.jarvis.espressotest.R;

import org.hamcrest.core.IsAnything;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NotesTest {

    @Rule
    public ActivityTestRule<NotesActivity> mNotesActivityActivityTestRule = new ActivityTestRule<>(NotesActivity.class);

    @Test
    public void noteSaved() throws Exception {
        Espresso.onView(ViewMatchers.withId(R.id.btn_save_note)).perform(ViewActions.click());

//        if (getListViewItemCount() > 0){
//            Espresso.onView(ViewMatchers.withId(R.id.list_view_notes)).perform(ViewActions.click());
//        }

        /*Checking if notes list size is >0*/
        Assert.assertTrue(getListViewItemCount()>0);
    }



    private int getListViewItemCount(){
        ListView listView = (ListView) mNotesActivityActivityTestRule.getActivity().findViewById(R.id.list_view_notes);
        return listView.getAdapter().getCount();
    }

}
