package org.borrow.backend.config.db.mongo

import org.borrow.backend.config.db.mongo.command.CreateUserCollectionCommand

/**
 * It prepares mongo commands to be run.
 */
class MongoCommandFactory {
    fun getCommandsToProcess(): Collection<MongoCommand> {
        return listOf(CreateUserCollectionCommand())
    }
}