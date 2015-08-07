databaseChangeLog = {

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-1") {
		addColumn(tableName: "activity") {
			column(name: "contact_id", type: "bigint")
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-2") {
		dropNotNullConstraint(columnDataType: "bigint", columnName: "musician_id", tableName: "activity")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-3") {
		dropForeignKeyConstraint(baseTableName: "contact_activity", baseTableSchemaName: "cien_hundreds", constraintName: "FK_eygk2wwq8fbuaqs5upyovfoa4")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-4") {
		dropForeignKeyConstraint(baseTableName: "contact_activity", baseTableSchemaName: "cien_hundreds", constraintName: "FK_14t24sbaj9n6eirub0o53vnbf")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-6") {
		createIndex(indexName: "FK_7bmnocxf54ke8plico2vv58qn", tableName: "activity") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-7") {
		dropTable(tableName: "contact_activity")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438897513761-5") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "activity", constraintName: "FK_7bmnocxf54ke8plico2vv58qn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}
}
