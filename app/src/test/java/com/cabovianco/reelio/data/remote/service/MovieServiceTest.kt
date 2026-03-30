package com.cabovianco.reelio.data.remote.service

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class MovieServiceTest {
    private lateinit var server: MockWebServer
    private lateinit var service: MovieService

    @Before
    fun setUp() {
        server = MockWebServer()
        server.start()

        val json = Json { ignoreUnknownKeys = true }

        service = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(MovieService::class.java)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun movieDiscover_whenResponseIsSuccessful_returnsDiscoverResponseDto() = runTest {
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(
                    """
                        {
                          "page": 1,
                          "results": [
                            {
                              "adult": false,
                              "backdrop_path": "/eNJhWy7xFzR74SYaSJHqJZuroDm.jpg",
                              "genre_ids": [
                                28,
                                878
                              ],
                              "id": 1033219,
                              "original_language": "en",
                              "original_title": "Attack on Titan",
                              "overview": "As viable water is depleted on Earth, a mission is sent to Saturn's moon Titan to retrieve sustainable H2O reserves from its alien inhabitants. But just as the humans acquire the precious resource, they are attacked by Titan rebels, who don't trust that the Earthlings will leave in peace.",
                              "popularity": 875.796,
                              "poster_path": "/qNz4l8UgTkD8rlqiKZ556pCJ9iO.jpg",
                              "release_date": "2022-09-30",
                              "title": "Attack on Titan",
                              "video": false,
                              "vote_average": 6.1,
                              "vote_count": 104
                            }
                          ],
                          "total_pages": 38020,
                          "total_results": 760385
                        }
                    """.trimIndent()
                )
        )

        val discoverResponse = service.movieDiscover()
        val movieResponse = discoverResponse.results.first()

        assertEquals(1, discoverResponse.page)
        assertEquals(38020, discoverResponse.totalPages)
        assertEquals(760385, discoverResponse.totalResults)

        assertEquals(1033219, movieResponse.id)
        assertEquals("Attack on Titan", movieResponse.title)
        assertEquals("As viable water is depleted on Earth, a mission is sent to Saturn's moon Titan to retrieve sustainable H2O reserves from its alien inhabitants. But just as the humans acquire the precious resource, they are attacked by Titan rebels, who don't trust that the Earthlings will leave in peace.", movieResponse.overview)
        assertEquals("/qNz4l8UgTkD8rlqiKZ556pCJ9iO.jpg", movieResponse.posterPath)
        assertEquals("2022-09-30", movieResponse.releaseDate)
        assertEquals(6.1, movieResponse.voteAverage)
    }

    @Test
    fun movieDiscover_whenPageIs2_returnsPage2() = runTest {
        server.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(
                    """
                        {
                          "page": 2,
                          "results": [],
                          "total_pages": 38020,
                          "total_results": 760385
                        }
                    """.trimIndent()
                )
        )

        val discoverResponse = service.movieDiscover(page = 2)

        assertEquals(2, discoverResponse.page)
    }
}
