package org.borrow.backend.config.db.mongo

import com.mongodb.client.MongoDatabase
import io.quarkus.mongodb.panache.MongoEntity

/**
 * It executes command on mongo database
 */
abstract class MongoCommand {

    /**
     * Executes logic on given mongo database
     *
     * @param mongoDatabase mongo database object
     */
    abstract fun execute(mongoDatabase: MongoDatabase)

    protected fun <T> getCollectionName(classType: Class<T>): String {
        return classType.getAnnotation(MongoEntity::class.java).collection
    }
}