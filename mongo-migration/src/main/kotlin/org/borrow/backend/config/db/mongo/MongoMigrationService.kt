package org.borrow.backend.config.db.mongo

import com.mongodb.client.MongoClient
import io.quarkus.arc.properties.IfBuildProperty
import io.quarkus.runtime.StartupEvent
import org.eclipse.microprofile.config.inject.ConfigProperty
import javax.enterprise.context.ApplicationScoped
import javax.enterprise.event.Observes

/**
 * On startup imports data to mongo database.
 */
@ApplicationScoped
@IfBuildProperty(name = "backend.mongo.migration.enabled", stringValue = "true")
class MongoMigrationService {
    @ConfigProperty(name = "quarkus.mongodb.database")
    private var databaseName = ""

    /**
     * It migrates data to mongo database
     * @param event startup event for quarkus to detect that this method has to be run on application startup
     * @param mongoClient mongo connection client
     */
    fun migrate(@Observes event: StartupEvent, mongoClient: MongoClient) {
        val mongoImporter = MongoImporter(mongoClient, MongoCommandFactory())
        mongoImporter.import(databaseName)
    }

}