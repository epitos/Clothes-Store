package exercise.coding.clothesstore.network

import exercise.coding.clothesstore.network.model.Cart
import exercise.coding.clothesstore.network.model.Product
import exercise.coding.clothesstore.utils.Constants
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiServiceInterface {
    @GET(Constants.GET_PRODUCTS)
    fun getProducts(): Observable<ArrayList<Product>>

    @POST(Constants.ADD_TO_CART)
    fun addToCart(@Body productId: Int): Observable<Cart>

    companion object {
        fun create(): ApiServiceInterface {
            val requestInterface = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return requestInterface.create(ApiServiceInterface::class.java)
        }
    }
}