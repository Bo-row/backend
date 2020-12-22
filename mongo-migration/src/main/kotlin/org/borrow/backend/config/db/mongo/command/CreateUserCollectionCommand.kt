package org.borrow.backend.config.db.mongo.command

import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.IndexOptions
import org.borrow.backend.config.db.mongo.MongoCommand
import org.borrow.backend.domain.User
import org.bson.BsonDocument

/**
 * It creates mongo user collection with required indexes.
 */
class CreateUserCollectionCommand: MongoCommand() {
    companion object {
        private const val EMAIL_INDEX_NAME = "user_email_index"
        private const val CREATE_EMAIL_INDEX_BSON = "{ email: 1}"
        private const val INDEX_NAME_PROPERTY = "name"
    }

    override fun execute(mongoDatabase: MongoDatabase) {
        val collection = mongoDatabase.getCollection(getCollectionName(User::class.java))
        if (!collection.listIndexes().any { it.get(INDEX_NAME_PROPERTY, String::class.java) == EMAIL_INDEX_NAME }) {
            collection.createIndex(BsonDocument.parse(CREATE_EMAIL_INDEX_BSON), IndexOptions().unique(true).name(EMAIL_INDEX_NAME))
        }
    }
}