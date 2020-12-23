package org.borrow.backend.config.db.mongo

import com.mongodb.client.MongoClient
import org.eclipse.microprofile.config.inject.ConfigProperty

/**
 * It runs set of [MongoCommand] on mongo database.
 */
class MongoImporter(
        private val mongoClient: MongoClient,
        private val mongoCommandFactory: MongoCommandFactory) {

    /**
     * It imports data to given database.
     *
     * @param databaseName name of database.
     */
    fun import(databaseName: String) {
        val database = mongoClient.getDatabase(databaseName)
        mongoCommandFactory.getCommandsToProcess().forEach { it.execute(database) }
    }
}