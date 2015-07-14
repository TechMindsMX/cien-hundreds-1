databaseChangeLog = {

	changeSet(author: "josdem (generated)", id: "1436902510213-1") {
		createTable(tableName: "activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "activityPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activity", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "place", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-2") {
		createTable(tableName: "address") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "addressPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "county", type: "varchar(100)")

			column(name: "datos_fiscales_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "neighborhood", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "state", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "street", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "town", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zipcode", type: "varchar(5)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-3") {
		createTable(tableName: "audio") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "audioPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-4") {
		createTable(tableName: "business_activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "business_actiPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-5") {
		createTable(tableName: "buyer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buyerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-6") {
		createTable(tableName: "collaborator") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "collaboratorPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "middle_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "position", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-7") {
		createTable(tableName: "collaborator_email") {
			column(name: "collaborator_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-8") {
		createTable(tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id", type: "bigint")

			column(name: "telephone_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-9") {
		createTable(tableName: "company") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "companyPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "assigned_id", type: "bigint")

			column(name: "corporate_press", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(10000)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "logo", type: "varchar(255)")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "tags", type: "varchar(10000)")

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "varchar(100)")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-10") {
		createTable(tableName: "company_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "company_commePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "collaborators", type: "longtext")

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales", type: "longtext")

			column(name: "description", type: "longtext")

			column(name: "events", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "notes", type: "longtext")

			column(name: "refs", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-11") {
		createTable(tableName: "company_validation") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "company_validPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-12") {
		createTable(tableName: "complement") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "complementPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-13") {
		createTable(tableName: "contact") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contactPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "biography", type: "varchar(10000)")

			column(name: "birth_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "entry_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "mother_last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "nationality", type: "varchar(50)")

			column(name: "other", type: "varchar(50)")

			column(name: "photo_path", type: "varchar(255)")

			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "style", type: "varchar(10000)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-14") {
		createTable(tableName: "contact_email") {
			column(name: "contact_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-15") {
		createTable(tableName: "datos_fiscales") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "datos_fiscalePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "persona_juridica", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "razon_social", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "rfc", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-16") {
		createTable(tableName: "email") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "emailPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-17") {
		createTable(tableName: "event") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "eventPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activity", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "place", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-18") {
		createTable(tableName: "facilitator") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "facilitatorPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-19") {
		createTable(tableName: "genre") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genrePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-20") {
		createTable(tableName: "musician") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musicianPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "assigned_id", type: "bigint")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "formed", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "genre_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "has_manager", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "history", type: "varchar(10000)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "logo_path", type: "varchar(36)")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "varchar(100)")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-21") {
		createTable(tableName: "musician_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_commPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activities", type: "longtext")

			column(name: "contacts", type: "longtext")

			column(name: "datos_fiscales", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "history", type: "longtext")

			column(name: "medias", type: "longtext")

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "longtext")

			column(name: "suggestions", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-22") {
		createTable(tableName: "musician_role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-23") {
		createTable(tableName: "musician_validation") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_valiPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)")

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-24") {
		createTable(tableName: "photo") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "photoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "path", type: "varchar(36)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-25") {
		createTable(tableName: "product") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "productPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "benefits", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "campaign", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "campaign_description", type: "longtext")

			column(name: "clients", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "competence", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "customer_model", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "discount_model", type: "longtext")

			column(name: "distribution_model", type: "longtext")

			column(name: "event", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "event_description", type: "longtext")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "longtext")

			column(name: "other", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "other_description", type: "longtext")

			column(name: "post_sale_model", type: "longtext")

			column(name: "product_comment_id", type: "bigint")

			column(name: "sales_model", type: "longtext")

			column(name: "target", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "telephone", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "telephone_description", type: "longtext")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "video_link", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "web_description", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-26") {
		createTable(tableName: "product_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "product_commePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "benefits", type: "longtext")

			column(name: "competence", type: "longtext")

			column(name: "customer_model", type: "longtext")

			column(name: "description", type: "longtext")

			column(name: "discount_model", type: "longtext")

			column(name: "distribution_model", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "notes", type: "longtext")

			column(name: "target", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-27") {
		createTable(tableName: "profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "middle_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

			column(name: "photo_path", type: "varchar(255)")

			column(name: "resume_path", type: "varchar(255)")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-28") {
		createTable(tableName: "reference") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "referencePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-29") {
		createTable(tableName: "registration_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_PK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "timestamp", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-30") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-31") {
		createTable(tableName: "social") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "socialPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "facebook", type: "varchar(100)")

			column(name: "google_plus", type: "varchar(100)")

			column(name: "instagram", type: "varchar(100)")

			column(name: "linkedin", type: "varchar(100)")

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "other", type: "varchar(100)")

			column(name: "twitter", type: "varchar(100)")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "youtube", type: "varchar(100)")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-32") {
		createTable(tableName: "suggestion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "suggestionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-33") {
		createTable(tableName: "tag") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "value", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-34") {
		createTable(tableName: "telephone") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "telephonePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-35") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-36") {
		createTable(tableName: "user_email") {
			column(name: "user_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-37") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-38") {
		createTable(tableName: "user_telephone") {
			column(name: "user_telephones_id", type: "bigint")

			column(name: "telephone_id", type: "bigint")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-39") {
		createTable(tableName: "validation_message") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "validation_mePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-40") {
		createTable(tableName: "video") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "videoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-41") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-94") {
		createIndex(indexName: "FK_s4saebhlisgfv458ks5lxwfk5", tableName: "activity") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-95") {
		createIndex(indexName: "FK_562ovss2fxuslx3ad2ld0wr9x", tableName: "address") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-96") {
		createIndex(indexName: "FK_891kjfcuawa7kebtjg91sywf1", tableName: "address") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-97") {
		createIndex(indexName: "FK_pn2ccaa2xu9ho36i5g7iwp03n", tableName: "address") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-98") {
		createIndex(indexName: "FK_qj3hvbo2i85kbh61ktm80aw5f", tableName: "address") {
			column(name: "datos_fiscales_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-99") {
		createIndex(indexName: "company_id_uniq_1436902510107", tableName: "address", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-100") {
		createIndex(indexName: "contact_id_uniq_1436902510111", tableName: "address", unique: "true") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-101") {
		createIndex(indexName: "datos_fiscales_id_uniq_1436902510111", tableName: "address", unique: "true") {
			column(name: "datos_fiscales_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-102") {
		createIndex(indexName: "musician_id_uniq_1436902510111", tableName: "address", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-103") {
		createIndex(indexName: "FK_oo0qi54r09mffw0s7tdls4vnn", tableName: "audio") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-104") {
		createIndex(indexName: "FK_apavm25dnckvwx0igxixayr5o", tableName: "collaborator") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-105") {
		createIndex(indexName: "FK_auky8gkjodx3yb2t9l23h8bb5", tableName: "collaborator_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-106") {
		createIndex(indexName: "FK_h7js0t8kueou4pxujy46ccs28", tableName: "collaborator_email") {
			column(name: "collaborator_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-107") {
		createIndex(indexName: "FK_4riy8s0t2j3acc4dx29188m5g", tableName: "collaborator_telephone") {
			column(name: "telephone_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-108") {
		createIndex(indexName: "FK_jtq3b6cm067b8cbx0949bn1nf", tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-109") {
		createIndex(indexName: "FK_6fame86hdykgo8wlb2nfkleju", tableName: "company") {
			column(name: "type_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-110") {
		createIndex(indexName: "FK_g82ixrst2tc542u5s214ggpdf", tableName: "company") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-111") {
		createIndex(indexName: "FK_px7wpskggmaqyv5hugyhmlrh", tableName: "company") {
			column(name: "assigned_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-112") {
		createIndex(indexName: "FK_27svoac7udkgucob8x42cgk8n", tableName: "company_comment") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-113") {
		createIndex(indexName: "company_id_uniq_1436902510123", tableName: "company_comment", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-114") {
		createIndex(indexName: "FK_a8s8459b3eicx6pllc4de0e3m", tableName: "company_validation") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-115") {
		createIndex(indexName: "FK_leia2q4jssj66evlfoi9u1sey", tableName: "company_validation") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-116") {
		createIndex(indexName: "company_id_uniq_1436902510124", tableName: "company_validation", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-117") {
		createIndex(indexName: "FK_41xvdqhy8jitwhyulfoox9aei", tableName: "complement") {
			column(name: "product_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-118") {
		createIndex(indexName: "FK_8rcuhh4i0uum1tryi4tkaomoq", tableName: "contact") {
			column(name: "role_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-119") {
		createIndex(indexName: "FK_qce5hi0s8xngx6abn6t5qqdh1", tableName: "contact") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-120") {
		createIndex(indexName: "FK_cympokuqia82xrakkgmo81je", tableName: "contact_email") {
			column(name: "contact_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-121") {
		createIndex(indexName: "FK_iarmsp0o5pw64ns9nitrnpyc1", tableName: "contact_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-122") {
		createIndex(indexName: "FK_f7nlnyw9e45c4qt713m2o55ny", tableName: "datos_fiscales") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-123") {
		createIndex(indexName: "FK_fq8rbpmha1g4tv7lcsf6ry998", tableName: "datos_fiscales") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-124") {
		createIndex(indexName: "company_id_uniq_1436902510128", tableName: "datos_fiscales", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-125") {
		createIndex(indexName: "musician_id_uniq_1436902510128", tableName: "datos_fiscales", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-126") {
		createIndex(indexName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", tableName: "event") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-127") {
		createIndex(indexName: "FK_clcuv4femydlirbpxllqabp47", tableName: "musician") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-128") {
		createIndex(indexName: "FK_ls5crp81sdo77jp2aoh4jfboo", tableName: "musician") {
			column(name: "genre_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-129") {
		createIndex(indexName: "FK_sykchqeqn5e6rfa8shuan9tm8", tableName: "musician") {
			column(name: "assigned_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-130") {
		createIndex(indexName: "FK_o0a4t8njpy2begfa4hece9wn3", tableName: "musician_comment") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-131") {
		createIndex(indexName: "musician_id_uniq_1436902510136", tableName: "musician_comment", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-132") {
		createIndex(indexName: "FK_8fusjimaf8xewyyosua1cwn09", tableName: "musician_validation") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-133") {
		createIndex(indexName: "FK_looghw1dl328qony0vspjkxxl", tableName: "musician_validation") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-134") {
		createIndex(indexName: "musician_id_uniq_1436902510137", tableName: "musician_validation", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-135") {
		createIndex(indexName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", tableName: "photo") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-136") {
		createIndex(indexName: "FK_45g3a4rexapplpirj3jor716p", tableName: "product") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-137") {
		createIndex(indexName: "FK_aqyrrujh6k7xk02bupabc98vq", tableName: "product") {
			column(name: "product_comment_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-138") {
		createIndex(indexName: "email_uniq_1436902510142", tableName: "profile", unique: "true") {
			column(name: "email")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-139") {
		createIndex(indexName: "FK_7ismr0wetsn4sdv1n0r55ip4a", tableName: "reference") {
			column(name: "type_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-140") {
		createIndex(indexName: "FK_o61ou11akolomal5ne95bpsh7", tableName: "reference") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-141") {
		createIndex(indexName: "authority_uniq_1436902510145", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-142") {
		createIndex(indexName: "FK_aelfuud5aqe0q1uj0wv2u2fy1", tableName: "social") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-143") {
		createIndex(indexName: "FK_c159pmynbmyu5asgl5a51hx01", tableName: "social") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-144") {
		createIndex(indexName: "FK_fjho9rx6d7776xyshprml75fn", tableName: "social") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-145") {
		createIndex(indexName: "company_id_uniq_1436902510146", tableName: "social", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-146") {
		createIndex(indexName: "contact_id_uniq_1436902510146", tableName: "social", unique: "true") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-147") {
		createIndex(indexName: "musician_id_uniq_1436902510146", tableName: "social", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-148") {
		createIndex(indexName: "FK_9kbb6ggcjy9kusn382c6dauwk", tableName: "suggestion") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-149") {
		createIndex(indexName: "FK_e9hkr3lux8eeph5dhgvd1b6sq", tableName: "tag") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-150") {
		createIndex(indexName: "FK_cgavsyoc3ot92fi9nu8mgheis", tableName: "telephone") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-151") {
		createIndex(indexName: "FK_1mcjtpxmwom9h9bf2q0k412e0", tableName: "user") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-152") {
		createIndex(indexName: "username_uniq_1436902510150", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-153") {
		createIndex(indexName: "FK_c6icvhh11873ab6ys4t6lmj9l", tableName: "user_email") {
			column(name: "user_emails_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-154") {
		createIndex(indexName: "FK_ga2lakvpd1h851gbjmv45ln0g", tableName: "user_email") {
			column(name: "email_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-155") {
		createIndex(indexName: "FK_apcc8lxk2xnug8377fatvbn04", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-156") {
		createIndex(indexName: "FK_it77eq964jhfqtu54081ebtio", tableName: "user_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-157") {
		createIndex(indexName: "FK_kayqg2jxrv0cbqvflyjhiy41g", tableName: "user_telephone") {
			column(name: "telephone_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-158") {
		createIndex(indexName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", tableName: "user_telephone") {
			column(name: "user_telephones_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-159") {
		createIndex(indexName: "FK_3ugn6wij9gp6ryqbt38qt61jb", tableName: "validation_message") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-160") {
		createIndex(indexName: "FK_al181veet6d6uh3x3fpx7y5y7", tableName: "validation_message") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-161") {
		createIndex(indexName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", tableName: "video") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-42") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "activity", constraintName: "FK_s4saebhlisgfv458ks5lxwfk5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-43") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "address", constraintName: "FK_562ovss2fxuslx3ad2ld0wr9x", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-44") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "address", constraintName: "FK_891kjfcuawa7kebtjg91sywf1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-45") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "address", constraintName: "FK_qj3hvbo2i85kbh61ktm80aw5f", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-46") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "address", constraintName: "FK_pn2ccaa2xu9ho36i5g7iwp03n", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-47") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "audio", constraintName: "FK_oo0qi54r09mffw0s7tdls4vnn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-48") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "collaborator", constraintName: "FK_apavm25dnckvwx0igxixayr5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-49") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_emails_id", baseTableName: "collaborator_email", constraintName: "FK_h7js0t8kueou4pxujy46ccs28", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-50") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "collaborator_email", constraintName: "FK_auky8gkjodx3yb2t9l23h8bb5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-51") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_telephones_id", baseTableName: "collaborator_telephone", constraintName: "FK_jtq3b6cm067b8cbx0949bn1nf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-52") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "collaborator_telephone", constraintName: "FK_4riy8s0t2j3acc4dx29188m5g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-53") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "company", constraintName: "FK_px7wpskggmaqyv5hugyhmlrh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-54") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "company", constraintName: "FK_6fame86hdykgo8wlb2nfkleju", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-55") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company", constraintName: "FK_g82ixrst2tc542u5s214ggpdf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-56") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_comment", constraintName: "FK_27svoac7udkgucob8x42cgk8n", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-57") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_validation", constraintName: "FK_a8s8459b3eicx6pllc4de0e3m", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-58") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company_validation", constraintName: "FK_leia2q4jssj66evlfoi9u1sey", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-59") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "complement", constraintName: "FK_41xvdqhy8jitwhyulfoox9aei", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-60") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "contact", constraintName: "FK_qce5hi0s8xngx6abn6t5qqdh1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-61") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "contact", constraintName: "FK_8rcuhh4i0uum1tryi4tkaomoq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-62") {
		addForeignKeyConstraint(baseColumnNames: "contact_emails_id", baseTableName: "contact_email", constraintName: "FK_cympokuqia82xrakkgmo81je", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-63") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "contact_email", constraintName: "FK_iarmsp0o5pw64ns9nitrnpyc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-64") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "datos_fiscales", constraintName: "FK_fq8rbpmha1g4tv7lcsf6ry998", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-65") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "datos_fiscales", constraintName: "FK_f7nlnyw9e45c4qt713m2o55ny", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-66") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "event", constraintName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-67") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "musician", constraintName: "FK_sykchqeqn5e6rfa8shuan9tm8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-68") {
		addForeignKeyConstraint(baseColumnNames: "genre_id", baseTableName: "musician", constraintName: "FK_ls5crp81sdo77jp2aoh4jfboo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genre", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-69") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician", constraintName: "FK_clcuv4femydlirbpxllqabp47", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-70") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_comment", constraintName: "FK_o0a4t8njpy2begfa4hece9wn3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-71") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_validation", constraintName: "FK_8fusjimaf8xewyyosua1cwn09", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-72") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician_validation", constraintName: "FK_looghw1dl328qony0vspjkxxl", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-73") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "photo", constraintName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-74") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "product", constraintName: "FK_45g3a4rexapplpirj3jor716p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-75") {
		addForeignKeyConstraint(baseColumnNames: "product_comment_id", baseTableName: "product", constraintName: "FK_aqyrrujh6k7xk02bupabc98vq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-76") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "reference", constraintName: "FK_o61ou11akolomal5ne95bpsh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-77") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "reference", constraintName: "FK_7ismr0wetsn4sdv1n0r55ip4a", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-78") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "social", constraintName: "FK_c159pmynbmyu5asgl5a51hx01", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-79") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "social", constraintName: "FK_fjho9rx6d7776xyshprml75fn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-80") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "social", constraintName: "FK_aelfuud5aqe0q1uj0wv2u2fy1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-81") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "suggestion", constraintName: "FK_9kbb6ggcjy9kusn382c6dauwk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-82") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "tag", constraintName: "FK_e9hkr3lux8eeph5dhgvd1b6sq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-83") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "telephone", constraintName: "FK_cgavsyoc3ot92fi9nu8mgheis", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-84") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "user", constraintName: "FK_1mcjtpxmwom9h9bf2q0k412e0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-85") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "user_email", constraintName: "FK_ga2lakvpd1h851gbjmv45ln0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-86") {
		addForeignKeyConstraint(baseColumnNames: "user_emails_id", baseTableName: "user_email", constraintName: "FK_c6icvhh11873ab6ys4t6lmj9l", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-87") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-88") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-89") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "user_telephone", constraintName: "FK_kayqg2jxrv0cbqvflyjhiy41g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-90") {
		addForeignKeyConstraint(baseColumnNames: "user_telephones_id", baseTableName: "user_telephone", constraintName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-91") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "validation_message", constraintName: "FK_3ugn6wij9gp6ryqbt38qt61jb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-92") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "validation_message", constraintName: "FK_al181veet6d6uh3x3fpx7y5y7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436902510213-93") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "video", constraintName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}
}
