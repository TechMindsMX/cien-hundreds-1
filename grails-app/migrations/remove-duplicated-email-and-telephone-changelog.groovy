databaseChangeLog = {

	changeSet(author: "josdem (generated)", id: "1436808474688-1") {
		createTable(tableName: "contact_email") {
			column(name: "contact_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-2") {
		addColumn(tableName: "collaborator_email") {
			column(name: "collaborator_emails_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-3") {
		addColumn(tableName: "collaborator_email") {
			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-4") {
		addColumn(tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-5") {
		addColumn(tableName: "collaborator_telephone") {
			column(name: "telephone_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-6") {
		addColumn(tableName: "user_email") {
			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-7") {
		addColumn(tableName: "user_email") {
			column(name: "user_emails_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-8") {
		addColumn(tableName: "user_telephone") {
			column(name: "telephone_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-9") {
		addColumn(tableName: "user_telephone") {
			column(name: "user_telephones_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-10") {
		dropPrimaryKey(tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-11") {
		dropPrimaryKey(tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-12") {
		dropPrimaryKey(tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-13") {
		dropPrimaryKey(tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-14") {
		dropForeignKeyConstraint(baseTableName: "collaborator_email", baseTableSchemaName: "cien_hundreds", constraintName: "FK_5vff0udp8d8jtr6l8d105r12y")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-15") {
		dropForeignKeyConstraint(baseTableName: "collaborator_telephone", baseTableSchemaName: "cien_hundreds", constraintName: "FK_mklcupfdxew17uws985qj59e7")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-16") {
		dropForeignKeyConstraint(baseTableName: "email", baseTableSchemaName: "cien_hundreds", constraintName: "FK_e6jy6w1ggpr1e54w5dhuu2qq6")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-17") {
		dropForeignKeyConstraint(baseTableName: "user_email", baseTableSchemaName: "cien_hundreds", constraintName: "FK_h4hfimhmy369x97qh3v284fjs")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-18") {
		dropForeignKeyConstraint(baseTableName: "user_telephone", baseTableSchemaName: "cien_hundreds", constraintName: "FK_9r92qvyo8xet4112knivtx8oh")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-29") {
		createIndex(indexName: "FK_auky8gkjodx3yb2t9l23h8bb5", tableName: "collaborator_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-30") {
		createIndex(indexName: "FK_h7js0t8kueou4pxujy46ccs28", tableName: "collaborator_email") {
			column(name: "collaborator_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-31") {
		createIndex(indexName: "FK_4riy8s0t2j3acc4dx29188m5g", tableName: "collaborator_telephone") {
			column(name: "telephone_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-32") {
		createIndex(indexName: "FK_jtq3b6cm067b8cbx0949bn1nf", tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-33") {
		createIndex(indexName: "FK_cympokuqia82xrakkgmo81je", tableName: "contact_email") {
			column(name: "contact_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-34") {
		createIndex(indexName: "FK_iarmsp0o5pw64ns9nitrnpyc1", tableName: "contact_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-35") {
		createIndex(indexName: "FK_c6icvhh11873ab6ys4t6lmj9l", tableName: "user_email") {
			column(name: "user_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-36") {
		createIndex(indexName: "FK_ga2lakvpd1h851gbjmv45ln0g", tableName: "user_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-37") {
		createIndex(indexName: "FK_kayqg2jxrv0cbqvflyjhiy41g", tableName: "user_telephone") {
			column(name: "telephone_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-38") {
		createIndex(indexName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", tableName: "user_telephone") {
			column(name: "user_telephones_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-39") {
		dropColumn(columnName: "address", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-40") {
		dropColumn(columnName: "collaborator_id", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-41") {
		dropColumn(columnName: "id", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-42") {
		dropColumn(columnName: "type", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-43") {
		dropColumn(columnName: "uuid", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-44") {
		dropColumn(columnName: "version", tableName: "collaborator_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-45") {
		dropColumn(columnName: "collaborator_id", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-46") {
		dropColumn(columnName: "id", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-47") {
		dropColumn(columnName: "phone", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-48") {
		dropColumn(columnName: "type", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-49") {
		dropColumn(columnName: "uuid", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-50") {
		dropColumn(columnName: "version", tableName: "collaborator_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-51") {
		dropColumn(columnName: "contact_id", tableName: "email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-52") {
		dropColumn(columnName: "address", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-53") {
		dropColumn(columnName: "id", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-54") {
		dropColumn(columnName: "type", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-55") {
		dropColumn(columnName: "user_id", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-56") {
		dropColumn(columnName: "uuid", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-57") {
		dropColumn(columnName: "version", tableName: "user_email")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-58") {
		dropColumn(columnName: "id", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-59") {
		dropColumn(columnName: "phone", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-60") {
		dropColumn(columnName: "type", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-61") {
		dropColumn(columnName: "user_id", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-62") {
		dropColumn(columnName: "uuid", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-63") {
		dropColumn(columnName: "version", tableName: "user_telephone")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-19") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_emails_id", baseTableName: "collaborator_email", constraintName: "FK_h7js0t8kueou4pxujy46ccs28", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-20") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "collaborator_email", constraintName: "FK_auky8gkjodx3yb2t9l23h8bb5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-21") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_telephones_id", baseTableName: "collaborator_telephone", constraintName: "FK_jtq3b6cm067b8cbx0949bn1nf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-22") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "collaborator_telephone", constraintName: "FK_4riy8s0t2j3acc4dx29188m5g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-23") {
		addForeignKeyConstraint(baseColumnNames: "contact_emails_id", baseTableName: "contact_email", constraintName: "FK_cympokuqia82xrakkgmo81je", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-24") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "contact_email", constraintName: "FK_iarmsp0o5pw64ns9nitrnpyc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-25") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "user_email", constraintName: "FK_ga2lakvpd1h851gbjmv45ln0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-26") {
		addForeignKeyConstraint(baseColumnNames: "user_emails_id", baseTableName: "user_email", constraintName: "FK_c6icvhh11873ab6ys4t6lmj9l", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-27") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "user_telephone", constraintName: "FK_kayqg2jxrv0cbqvflyjhiy41g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436808474688-28") {
		addForeignKeyConstraint(baseColumnNames: "user_telephones_id", baseTableName: "user_telephone", constraintName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
