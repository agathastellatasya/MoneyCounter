package com.veren.android.moneycounter

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Veren on 6/6/2018.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testTextView100k() {
        onView(withId(R.id.input100k)).perform(typeText("1"))
        onView(withId(R.id.count100k)).check(matches(withText("Rp100.000")))
        onView(withId(R.id.total)).check(matches(withText("100000")))
    }

    @Test
    fun testTextView50k() {
        onView(withId(R.id.input50k)).perform(typeText("1"))
        onView(withId(R.id.count50k)).check(matches(withText("Rp50.000")))
        onView(withId(R.id.total)).check(matches(withText("50000")))
    }

    @Test
    fun testTextView20k() {
        onView(withId(R.id.input20k)).perform(typeText("1"))
        onView(withId(R.id.count20k)).check(matches(withText("Rp20.000")))
        onView(withId(R.id.total)).check(matches(withText("20000")))
    }

    @Test
    fun testTextView10k() {
        onView(withId(R.id.input10k)).perform(typeText("1"))
        onView(withId(R.id.count10k)).check(matches(withText("Rp10.000")))
        onView(withId(R.id.total)).check(matches(withText("10000")))
    }

    @Test
    fun testTextView5k() {
        onView(withId(R.id.input5k)).perform(typeText("1"))
        onView(withId(R.id.count5k)).check(matches(withText("Rp5.000")))
        onView(withId(R.id.total)).check(matches(withText("5000")))
    }

    @Test
    fun testTextView2k() {
        onView(withId(R.id.input2k)).perform(typeText("1"))
        onView(withId(R.id.count2k)).check(matches(withText("Rp2.000")))
        onView(withId(R.id.total)).check(matches(withText("2000")))
    }

    @Test
    fun testTextView1k() {
        onView(withId(R.id.input1k)).perform(typeText("1"))
        onView(withId(R.id.count1k)).check(matches(withText("Rp1.000")))
        onView(withId(R.id.total)).check(matches(withText("1000")))
    }

    @Test
    fun testTextView500() {
        onView(withId(R.id.input500)).perform(typeText("1"))
        onView(withId(R.id.count500)).check(matches(withText("Rp500")))
        onView(withId(R.id.total)).check(matches(withText("500")))
    }

    @Test
    fun testTextView200() {
        onView(withId(R.id.scrollContainer)).perform(swipeUp())
        onView(withId(R.id.input200)).perform(typeText("1"))
        onView(withId(R.id.count200)).check(matches(withText("Rp200")))
        onView(withId(R.id.total)).check(matches(withText("200")))
    }

    @Test
    fun testTextView100() {
        onView(withId(R.id.scrollContainer)).perform(swipeUp())
        onView(withId(R.id.input100)).perform(typeText("2"))
        onView(withId(R.id.count100)).check(matches(withText("Rp200")))
        onView(withId(R.id.total)).check(matches(withText("200")))
    }

    @Test
    fun testTotal() {
        onView(withId(R.id.input100k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input50k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input20k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input10k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input5k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input2k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input1k)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input500)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input200)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.input100)).perform(typeText("1"), closeSoftKeyboard())
        onView(withId(R.id.total)).check(matches(withText("188800")))
    }
}