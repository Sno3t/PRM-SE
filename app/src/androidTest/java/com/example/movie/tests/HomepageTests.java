package com.example.movie.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



import static org.hamcrest.CoreMatchers.containsString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.movie.R;
import com.example.movie.presentation.MainActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class HomepageTests {

    @Rule
    public ActivityScenarioRule<MainActivity> testing = new ActivityScenarioRule<MainActivity>(MainActivity.class);

    @Test
    public void homePageScroll(){
        homeButton();
        onView(withId(R.id.movie_recyclerview)).check(matches(isDisplayed()));
        onView(withText("Action")).check(matches(isDisplayed()));
        onView(withId(R.id.movie_recyclerview)).perform(swipeUp()).check(matches(isDisplayed()));
        onView(withId(R.id.movie_recyclerview)).perform(swipeLeft()).check(matches(isDisplayed()));
        onView(withId(R.id.movie_recyclerview)).perform(click());
    }

    @Test
    public void searchFunction(){
        homeButton();
        onView(withId(R.id.searchbar_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.searchbar_movie)).perform(click()).check(matches(isDisplayed()));
        onView(withId(R.id.searchbar_movie)).perform(typeText("Batman")).check(matches(isDisplayed()));
        onView(withText("Batman")).check(matches(isDisplayed()));
    }

    @Test
    public void homeButton(){
        onView(withId(R.id.home_nav_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.home_nav_btn)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void settingButton(){
        onView(withId(R.id.settings_nav_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.settings_nav_btn)).perform(click()).check(matches(isDisplayed()));
    }

    @Test
    public void listButton(){
        onView(withId(R.id.lists_nav_btn)).check(matches(isDisplayed()));
        onView(withId(R.id.lists_nav_btn)).perform(click()).check(matches(isDisplayed()));
    }

}
