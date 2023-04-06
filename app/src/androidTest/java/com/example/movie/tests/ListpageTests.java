package com.example.movie.tests;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;
import android.view.KeyEvent;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.anything;
import static org.junit.Assert.*;

import com.example.movie.R;
import com.example.movie.presentation.ListsActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListpageTests {
    @Rule
    public ActivityScenarioRule<ListsActivity> lAASR = new ActivityScenarioRule<ListsActivity>(ListsActivity.class);

    @Test
    public void RecyclerviewScrollTest(){
        onView(withId(R.id.lists_recyclerview)).check(matches(isDisplayed()));
        onView(withId(R.id.lists_recyclerview)).perform(swipeUp());
    }

    @Test
    public void GenrespinnerTest(){
        onView(withId(R.id.filter_spinner)).check(matches(isDisplayed()));
        onData(anything()).atPosition(0).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void SearchTest(){
        onView(withId(R.id.searchbar_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.searchbar_movie)).perform(typeText("fav")).perform(pressKey(KeyEvent.KEYCODE_ENTER));
    }

    @Test
    public void AddListButtonTest(){
        onView(withId(R.id.floatingActionButton)).check(matches(isDisplayed()));
        // onView(withId(R.id.floatingActionButton)).perform(click());
    }


}
