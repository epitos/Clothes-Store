package exercise.coding.clothesstore.network.model

import com.google.gson.annotations.SerializedName

data class Cart (
    @SerializedName("cartId") val cartId : Int,
    @SerializedName("productId") val productId : Int
)