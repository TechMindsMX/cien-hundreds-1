databaseChangeLog = {

	changeSet(author: "josdem (generated)", id: "1436401660288-1") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-2") {
		createTable(tableName: "address") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "addressPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "county", type: "varchar(100)")

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

	changeSet(author: "josdem (generated)", id: "1436401660288-3") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-4") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-5") {
		createTable(tableName: "buyer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buyerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-6") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-7") {
		createTable(tableName: "collaborator_email") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "collaborator_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "collaborator_id", type: "bigint") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-8") {
		createTable(tableName: "collaborator_telephone") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "collaborator_PK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "collaborator_id", type: "bigint") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-9") {
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

			column(name: "address_id", type: "bigint")

			column(name: "assigned_id", type: "bigint")

			column(name: "company_comment_id", type: "bigint")

			column(name: "corporate_press", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales_id", type: "bigint")

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

			column(name: "social_id", type: "bigint")

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

	changeSet(author: "josdem (generated)", id: "1436401660288-10") {
		createTable(tableName: "company_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "company_commePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "collaborators", type: "longtext")

			column(name: "datos_fiscales", type: "longtext")

			column(name: "description", type: "longtext")

			column(name: "events", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "notes", type: "longtext")

			column(name: "references", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-11") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-12") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-13") {
		createTable(tableName: "contact") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contactPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

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

			column(name: "social_id", type: "bigint")

			column(name: "style", type: "varchar(10000)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-14") {
		createTable(tableName: "datos_fiscales") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "datos_fiscalePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

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

	changeSet(author: "josdem (generated)", id: "1436401660288-15") {
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

			column(name: "contact_id", type: "bigint") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-16") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-17") {
		createTable(tableName: "facilitator") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "facilitatorPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-18") {
		createTable(tableName: "genre") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genrePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-19") {
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

			column(name: "address_id", type: "bigint")

			column(name: "assigned_id", type: "bigint")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales_id", type: "bigint")

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

			column(name: "musician_comment_id", type: "bigint")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "social_id", type: "bigint")

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "varchar(100)")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-20") {
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

			column(name: "notes", type: "longtext")

			column(name: "suggestions", type: "longtext")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-21") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-22") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-23") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-24") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-25") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-26") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-27") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-28") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-29") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-30") {
		createTable(tableName: "social") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "socialPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "facebook", type: "varchar(100)")

			column(name: "google_plus", type: "varchar(100)")

			column(name: "instagram", type: "varchar(100)")

			column(name: "linkedin", type: "varchar(100)")

			column(name: "other", type: "varchar(100)")

			column(name: "twitter", type: "varchar(100)")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "youtube", type: "varchar(100)")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-31") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-32") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-33") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-34") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-35") {
		createTable(tableName: "user_email") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "user_emailPK")
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

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-36") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-37") {
		createTable(tableName: "user_telephone") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "user_telephonPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

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

	changeSet(author: "josdem (generated)", id: "1436401660288-38") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-39") {
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

	changeSet(author: "josdem (generated)", id: "1436401660288-40") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-88") {
		createIndex(indexName: "FK_s4saebhlisgfv458ks5lxwfk5", tableName: "activity") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-89") {
		createIndex(indexName: "FK_oo0qi54r09mffw0s7tdls4vnn", tableName: "audio") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-90") {
		createIndex(indexName: "FK_apavm25dnckvwx0igxixayr5o", tableName: "collaborator") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-91") {
		createIndex(indexName: "FK_5vff0udp8d8jtr6l8d105r12y", tableName: "collaborator_email") {
			column(name: "collaborator_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-92") {
		createIndex(indexName: "FK_mklcupfdxew17uws985qj59e7", tableName: "collaborator_telephone") {
			column(name: "collaborator_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-93") {
		createIndex(indexName: "FK_29e7kigcj3o1n1hr7xdye8rma", tableName: "company") {
			column(name: "social_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-94") {
		createIndex(indexName: "FK_6fame86hdykgo8wlb2nfkleju", tableName: "company") {
			column(name: "type_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-95") {
		createIndex(indexName: "FK_g82ixrst2tc542u5s214ggpdf", tableName: "company") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-96") {
		createIndex(indexName: "FK_h2rewspdf9bnwpbt1nauwiaww", tableName: "company") {
			column(name: "address_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-97") {
		createIndex(indexName: "FK_px7wpskggmaqyv5hugyhmlrh", tableName: "company") {
			column(name: "assigned_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-98") {
		createIndex(indexName: "FK_q3h45mjxsg3t93b936hwbsn3i", tableName: "company") {
			column(name: "company_comment_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-99") {
		createIndex(indexName: "FK_qs2etwu504m9iiux8g6bxnbsr", tableName: "company") {
			column(name: "datos_fiscales_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-100") {
		createIndex(indexName: "FK_a8s8459b3eicx6pllc4de0e3m", tableName: "company_validation") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-101") {
		createIndex(indexName: "FK_leia2q4jssj66evlfoi9u1sey", tableName: "company_validation") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-102") {
		createIndex(indexName: "company_id_uniq_1436401660176", tableName: "company_validation", unique: "true") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-103") {
		createIndex(indexName: "FK_41xvdqhy8jitwhyulfoox9aei", tableName: "complement") {
			column(name: "product_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-104") {
		createIndex(indexName: "FK_8rcuhh4i0uum1tryi4tkaomoq", tableName: "contact") {
			column(name: "role_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-105") {
		createIndex(indexName: "FK_hdhcc7238a2lwr4yjw78qvlof", tableName: "contact") {
			column(name: "address_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-106") {
		createIndex(indexName: "FK_iu66rh5jr753g1snpeckccpnd", tableName: "contact") {
			column(name: "social_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-107") {
		createIndex(indexName: "FK_qce5hi0s8xngx6abn6t5qqdh1", tableName: "contact") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-108") {
		createIndex(indexName: "FK_pjuse4nbsyy9iapot4t48ji9c", tableName: "datos_fiscales") {
			column(name: "address_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-109") {
		createIndex(indexName: "FK_e6jy6w1ggpr1e54w5dhuu2qq6", tableName: "email") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-110") {
		createIndex(indexName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", tableName: "event") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-111") {
		createIndex(indexName: "FK_6w37t9ow427kbv6224o44umx7", tableName: "musician") {
			column(name: "musician_comment_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-112") {
		createIndex(indexName: "FK_c6m47md1l2deho73aq1vmk2hc", tableName: "musician") {
			column(name: "datos_fiscales_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-113") {
		createIndex(indexName: "FK_clcuv4femydlirbpxllqabp47", tableName: "musician") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-114") {
		createIndex(indexName: "FK_ls5crp81sdo77jp2aoh4jfboo", tableName: "musician") {
			column(name: "genre_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-115") {
		createIndex(indexName: "FK_nxah8pk0uolulpyldcbbn61j0", tableName: "musician") {
			column(name: "social_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-116") {
		createIndex(indexName: "FK_sykchqeqn5e6rfa8shuan9tm8", tableName: "musician") {
			column(name: "assigned_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-117") {
		createIndex(indexName: "FK_tnq8ruyw7fyhilr7l9m58b3iu", tableName: "musician") {
			column(name: "address_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-118") {
		createIndex(indexName: "FK_8fusjimaf8xewyyosua1cwn09", tableName: "musician_validation") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-119") {
		createIndex(indexName: "FK_looghw1dl328qony0vspjkxxl", tableName: "musician_validation") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-120") {
		createIndex(indexName: "musician_id_uniq_1436401660195", tableName: "musician_validation", unique: "true") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-121") {
		createIndex(indexName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", tableName: "photo") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-122") {
		createIndex(indexName: "FK_45g3a4rexapplpirj3jor716p", tableName: "product") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-123") {
		createIndex(indexName: "FK_aqyrrujh6k7xk02bupabc98vq", tableName: "product") {
			column(name: "product_comment_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-124") {
		createIndex(indexName: "email_uniq_1436401660202", tableName: "profile", unique: "true") {
			column(name: "email")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-125") {
		createIndex(indexName: "FK_7ismr0wetsn4sdv1n0r55ip4a", tableName: "reference") {
			column(name: "type_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-126") {
		createIndex(indexName: "FK_o61ou11akolomal5ne95bpsh7", tableName: "reference") {
			column(name: "company_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-127") {
		createIndex(indexName: "authority_uniq_1436401660205", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-128") {
		createIndex(indexName: "FK_9kbb6ggcjy9kusn382c6dauwk", tableName: "suggestion") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-129") {
		createIndex(indexName: "FK_e9hkr3lux8eeph5dhgvd1b6sq", tableName: "tag") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-130") {
		createIndex(indexName: "FK_cgavsyoc3ot92fi9nu8mgheis", tableName: "telephone") {
			column(name: "contact_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-131") {
		createIndex(indexName: "FK_1mcjtpxmwom9h9bf2q0k412e0", tableName: "user") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-132") {
		createIndex(indexName: "username_uniq_1436401660210", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-133") {
		createIndex(indexName: "FK_h4hfimhmy369x97qh3v284fjs", tableName: "user_email") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-134") {
		createIndex(indexName: "FK_apcc8lxk2xnug8377fatvbn04", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-135") {
		createIndex(indexName: "FK_it77eq964jhfqtu54081ebtio", tableName: "user_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-136") {
		createIndex(indexName: "FK_9r92qvyo8xet4112knivtx8oh", tableName: "user_telephone") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-137") {
		createIndex(indexName: "FK_3ugn6wij9gp6ryqbt38qt61jb", tableName: "validation_message") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-138") {
		createIndex(indexName: "FK_al181veet6d6uh3x3fpx7y5y7", tableName: "validation_message") {
			column(name: "user_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-139") {
		createIndex(indexName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", tableName: "video") {
			column(name: "musician_id")
		}
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-41") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "activity", constraintName: "FK_s4saebhlisgfv458ks5lxwfk5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-42") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "audio", constraintName: "FK_oo0qi54r09mffw0s7tdls4vnn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-43") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "collaborator", constraintName: "FK_apavm25dnckvwx0igxixayr5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-44") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_id", baseTableName: "collaborator_email", constraintName: "FK_5vff0udp8d8jtr6l8d105r12y", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-45") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_id", baseTableName: "collaborator_telephone", constraintName: "FK_mklcupfdxew17uws985qj59e7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-46") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "company", constraintName: "FK_h2rewspdf9bnwpbt1nauwiaww", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-47") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "company", constraintName: "FK_px7wpskggmaqyv5hugyhmlrh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-48") {
		addForeignKeyConstraint(baseColumnNames: "company_comment_id", baseTableName: "company", constraintName: "FK_q3h45mjxsg3t93b936hwbsn3i", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-49") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "company", constraintName: "FK_qs2etwu504m9iiux8g6bxnbsr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-50") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "company", constraintName: "FK_29e7kigcj3o1n1hr7xdye8rma", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-51") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "company", constraintName: "FK_6fame86hdykgo8wlb2nfkleju", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-52") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company", constraintName: "FK_g82ixrst2tc542u5s214ggpdf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-53") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_validation", constraintName: "FK_a8s8459b3eicx6pllc4de0e3m", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-54") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company_validation", constraintName: "FK_leia2q4jssj66evlfoi9u1sey", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-55") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "complement", constraintName: "FK_41xvdqhy8jitwhyulfoox9aei", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-56") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "contact", constraintName: "FK_hdhcc7238a2lwr4yjw78qvlof", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-57") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "contact", constraintName: "FK_qce5hi0s8xngx6abn6t5qqdh1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-58") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "contact", constraintName: "FK_8rcuhh4i0uum1tryi4tkaomoq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-59") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "contact", constraintName: "FK_iu66rh5jr753g1snpeckccpnd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-60") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "datos_fiscales", constraintName: "FK_pjuse4nbsyy9iapot4t48ji9c", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-61") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "email", constraintName: "FK_e6jy6w1ggpr1e54w5dhuu2qq6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-62") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "event", constraintName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-63") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "musician", constraintName: "FK_tnq8ruyw7fyhilr7l9m58b3iu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-64") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "musician", constraintName: "FK_sykchqeqn5e6rfa8shuan9tm8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-65") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "musician", constraintName: "FK_c6m47md1l2deho73aq1vmk2hc", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-66") {
		addForeignKeyConstraint(baseColumnNames: "genre_id", baseTableName: "musician", constraintName: "FK_ls5crp81sdo77jp2aoh4jfboo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genre", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-67") {
		addForeignKeyConstraint(baseColumnNames: "musician_comment_id", baseTableName: "musician", constraintName: "FK_6w37t9ow427kbv6224o44umx7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-68") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "musician", constraintName: "FK_nxah8pk0uolulpyldcbbn61j0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-69") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician", constraintName: "FK_clcuv4femydlirbpxllqabp47", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-70") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_validation", constraintName: "FK_8fusjimaf8xewyyosua1cwn09", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-71") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician_validation", constraintName: "FK_looghw1dl328qony0vspjkxxl", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-72") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "photo", constraintName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-73") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "product", constraintName: "FK_45g3a4rexapplpirj3jor716p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-74") {
		addForeignKeyConstraint(baseColumnNames: "product_comment_id", baseTableName: "product", constraintName: "FK_aqyrrujh6k7xk02bupabc98vq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-75") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "reference", constraintName: "FK_o61ou11akolomal5ne95bpsh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-76") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "reference", constraintName: "FK_7ismr0wetsn4sdv1n0r55ip4a", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-77") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "suggestion", constraintName: "FK_9kbb6ggcjy9kusn382c6dauwk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-78") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "tag", constraintName: "FK_e9hkr3lux8eeph5dhgvd1b6sq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-79") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "telephone", constraintName: "FK_cgavsyoc3ot92fi9nu8mgheis", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-80") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "user", constraintName: "FK_1mcjtpxmwom9h9bf2q0k412e0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-81") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_email", constraintName: "FK_h4hfimhmy369x97qh3v284fjs", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-82") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-83") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-84") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_telephone", constraintName: "FK_9r92qvyo8xet4112knivtx8oh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-85") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "validation_message", constraintName: "FK_3ugn6wij9gp6ryqbt38qt61jb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-86") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "validation_message", constraintName: "FK_al181veet6d6uh3x3fpx7y5y7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1436401660288-87") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "video", constraintName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}
}