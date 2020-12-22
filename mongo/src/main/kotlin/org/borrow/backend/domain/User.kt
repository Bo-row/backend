package org.borrow.backend.domain

import io.quarkus.mongodb.panache.MongoEntity
import io.quarkus.mongodb.panache.PanacheMongoEntity
import io.quarkus.mongodb.panache.PanacheMongoEntityBase
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.codecs.pojo.annotations.BsonProperty
import org.bson.types.ObjectId
import java.time.LocalDate

@MongoEntity(collection="User")
data class User @BsonCreator constructor(
        @BsonId val id: ObjectId = ObjectId(),
        @BsonProperty("firstName")
        val firstName: String,
        @BsonProperty("lastName")
        val lastName: String,
        @BsonProperty("email")
        val email: String,
        @BsonProperty("password")
        val password: String,
        @BsonProperty("phoneNumber")
        val phoneNumber: Int?,
        @BsonProperty("avatar")
        val avatar: String?
) : PanacheMongoEntityBase()