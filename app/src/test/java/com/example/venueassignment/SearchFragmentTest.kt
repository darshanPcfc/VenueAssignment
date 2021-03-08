package com.example.venueassignment

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.venueassignment.db.VenueDataSet
import com.example.venueassignment.di.apiInjections
import com.example.venueassignment.di.repositoriesInjection
import com.example.venueassignment.di.viewModelsInjection
import com.example.venueassignment.networkinterface.retrofit.createNetworkClient
import com.example.venueassignment.ui.fragment.searchfragment.SearchViewModel
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito
import retrofit2.Retrofit
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
class SearchFragmentTest : KoinTest {
    val model by inject<SearchViewModel>()

    //val service by inject<MainApiInterface>()
    private lateinit var retrofit: Retrofit

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val testDispatcher = TestCoroutineDispatcher()

    private val coroutineContext: CoroutineContext get() = testDispatcher
    private val coroutinescope: CoroutineScope = CoroutineScope(coroutineContext)
    private lateinit var venueRoomDatabase: VenueDataSet


    @Before
    fun setup() {
        retrofit = createNetworkClient()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Before
    fun startKoinForTest() {
        val mockedContext = Mockito.mock(Application::class.java)
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                androidLogger()
                androidContext(mockedContext)
                modules(listOf(apiInjections, repositoriesInjection, viewModelsInjection))
            }
        }
    }

    @After
    fun stopKoinAfterTest() = stopKoin()

    @Test
    fun `should pass when search list api response is not null`() {
        val result = model.search("mumbai")
        assertNotNull(result)
        assertTrue(result.toString().isNotEmpty())
    }
}