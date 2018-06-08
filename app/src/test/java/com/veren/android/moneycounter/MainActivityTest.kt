package com.veren.android.moneycounter

import org.junit.Assert
import org.junit.Test
import java.util.*
import org.junit.Before

/**
 * Created by Veren on 6/5/2018.
 */

class MainActivityTest {

    val main = MainActivity()
    var arr : ArrayList<Long> = ArrayList<Long>()

    @Before
    fun setUp() {
        arr.add(1)
        arr.add(2)
        arr.add(3)
        arr.add(4)
        arr.add(5)
        arr.add(6)
        arr.add(7)
        arr.add(8)
        arr.add(9)
        arr.add(10)
    }

    @Test
    fun sum_isCorrect() {
        Assert.assertEquals(55, main.sumTotal(arr))
    }

    @Test
    fun valueIdx_isCorrect() {
        Assert.assertEquals(100000, main.valueIdx(0))
        Assert.assertEquals(50000, main.valueIdx(1))
        Assert.assertEquals(20000, main.valueIdx(2))
        Assert.assertEquals(10000, main.valueIdx(3))
        Assert.assertEquals(5000, main.valueIdx(4))
        Assert.assertEquals(2000, main.valueIdx(5))
        Assert.assertEquals(1000, main.valueIdx(6))
        Assert.assertEquals(500, main.valueIdx(7))
        Assert.assertEquals(200, main.valueIdx(8))
        Assert.assertEquals(100, main.valueIdx(9))
    }
}
