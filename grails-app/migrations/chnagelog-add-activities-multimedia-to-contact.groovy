databaseChangeLog = {

	changeSet(author: "rlyon (generated)", id: "1438539255789-1") {
		createTable(tableName: "contact_activity") {
			column(name: "contact_activities_id", type: "bigint")

			column(name: "activity_id", type: "bigint")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-2") {
		addColumn(tableName: "audio") {
			column(name: "contact_id", type: "bigint")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-3") {
		addColumn(tableName: "photo") {
			column(name: "contact_id", type: "bigint")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-4") {
		addColumn(tableName: "video") {
			column(name: "contact_id", type: "bigint")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-5") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "musician_id", tableName: "audio")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-6") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "musician_id", tableName: "photo")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-7") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "musician_id", tableName: "video")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-13") {
		createIndex(indexName: "FK_t0vmjqsrm1plsd8ac475vgijj", tableName: "audio") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-14") {
		createIndex(indexName: "FK_14t24sbaj9n6eirub0o53vnbf", tableName: "contact_activity") {
			column(name: "contact_activities_id")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-15") {
		createIndex(indexName: "FK_eygk2wwq8fbuaqs5upyovfoa4", tableName: "contact_activity") {
			column(name: "activity_id")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-16") {
		createIndex(indexName: "FK_3u1lnvv911kyvvqn4uwtjmbdo", tableName: "photo") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-17") {
		createIndex(indexName: "FK_4wkopld2p5acy0fgipqvj5f9m", tableName: "video") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-8") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "audio", constraintName: "FK_t0vmjqsrm1plsd8ac475vgijj", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-9") {
		addForeignKeyConstraint(baseColumnNames: "activity_id", baseTableName: "contact_activity", constraintName: "FK_eygk2wwq8fbuaqs5upyovfoa4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-10") {
		addForeignKeyConstraint(baseColumnNames: "contact_activities_id", baseTableName: "contact_activity", constraintName: "FK_14t24sbaj9n6eirub0o53vnbf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-11") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "photo", constraintName: "FK_3u1lnvv911kyvvqn4uwtjmbdo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "rlyon (generated)", id: "1438539255789-12") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "video", constraintName: "FK_4wkopld2p5acy0fgipqvj5f9m", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}
}
