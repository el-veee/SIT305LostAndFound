package com.lachlanvass.sit315lostandfound

import androidx.room.*

@Entity
data class Post(

    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "phone_number") val phoneNumber: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "date") val date: String?,
    @ColumnInfo(name = "location") val location: String?
)

@Dao
interface PostDao {

    @Query("SELECT * FROM Post")
    fun getAll(): List<Post>

    @Delete
    fun delete(post: Post)
}

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao() : PostDao
}
