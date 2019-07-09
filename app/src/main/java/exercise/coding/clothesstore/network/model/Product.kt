package exercise.coding.clothesstore.network.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Product (
    @SerializedName("productId") val productId : Int,
    @SerializedName("name") val name : String,
    @SerializedName("category") val category : String,
    @SerializedName("price") val price : Double,
    @SerializedName("oldPrice") val oldPrice : String,
    @SerializedName("stock") val stock : Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(productId)
        parcel.writeString(name)
        parcel.writeString(category)
        parcel.writeDouble(price)
        parcel.writeString(oldPrice)
        parcel.writeInt(stock)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}