package me.walmyrcarvalho.recrutamentoandroid.ui.seasondetail;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import me.walmyrcarvalho.recrutamentoandroid.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@SmallTest
public class SeasonDetailTest {

    @Rule
    public ActivityTestRule<SeasonDetailActivity> testRule =
            new ActivityTestRule<>(SeasonDetailActivity.class);

    @Test
    public void testHeaderContentVisible() {
        onView(withId(R.id.season_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.season_header)).check(matches(isDisplayed()));
        onView(withId(R.id.season_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.episodes_label)).check(matches(isDisplayed()));
    }

    @Test
    public void testOpenOverflowMenuAndClose() {
        openContextualActionModeOverflowMenu();
    }

    @Test
    public void testOpenOverflowMenuThenChooseRefreshOption() {
        openContextualActionModeOverflowMenu();
        onView(withText(R.string.refresh)).perform(click());
    }

    @Test
    public void testOpenOverflowMenuThenChooseAboutOption() {
        openContextualActionModeOverflowMenu();
        onView(withText(R.string.about)).perform(click());
    }

    @Test
    public void testClickOnTheFirstItemOfEpisodesList() {
        onView(withId(R.id.recyclerview))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
