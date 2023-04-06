package com.example.movie.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.equalTo;
import com.example.movie.R;
import com.example.movie.presentation.MovieDetailsActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class DetailpageTests {
    @Rule
    public ActivityScenarioRule<MovieDetailsActivity> activityRule =
            new ActivityScenarioRule<MovieDetailsActivity>(MovieDetailsActivity.class);

    @Test
    public void addToFavoritesClicked() {
        onView(withId(R.id.favorite_btn)).perform(click());
        onView(withId(R.id.favorite_btn)).check(matches(withTagValue(equalTo(R.drawable.ic_filled_favorite_red))));
        onView(withId(R.id.favorite_btn)).perform(click());
        onView(withId(R.id.favorite_btn)).check(matches(withTagValue(equalTo(R.drawable.ic_filled_favorite))));
    }
}
