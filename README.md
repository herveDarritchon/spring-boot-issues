## Synopsis

#### In fact, there is invisible characters at the begining of the data-h2.sql file that cause SQL error at runtime !

A sample project of Spring-Boot-Data-JPA that initialize an embeded database (h2).
It produces an error at startup :

    Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory': Post-processing of FactoryBean's singleton object failed; nested exception is org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of URL [file:/Users/throdo/Programmation/Workspaces/Java/Embeded%20DB%20Initialisation%20Issue/target/classes/data-h2.sql]: ﻿INSERT INTO users (id, firstname, lastname, age) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23); nested exception is org.h2.jdbc.JdbcSQLException: Syntax error in SQL statement "﻿INSERT[*] INTO USERS (ID, FIRSTNAME, LASTNAME, AGE) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) "; SQL statement:
        INSERT INTO users (id, firstname, lastname, age) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) [42000-192]
	at org.springframework.beans.factory.support.FactoryBeanRegistrySupport.getObjectFromFactoryBean(FactoryBeanRegistrySupport.java:116)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getObjectForBeanInstance(AbstractBeanFactory.java:1595)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:254)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:220)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:351)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:332)
	at org.springframework.orm.jpa.EntityManagerFactoryUtils.findEntityManagerFactory(EntityManagerFactoryUtils.java:143)
	at org.springframework.orm.jpa.EntityManagerFactoryAccessor.setBeanFactory(EntityManagerFactoryAccessor.java:137)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeAwareMethods(AbstractAutowireCapableBeanFactory.java:1597)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1565)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:545)
	... 47 more

	Caused by: org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of URL [file:/Users/throdo/Programmation/Workspaces/Java/Embeded%20DB%20Initialisation%20Issue/target/classes/data-h2.sql]: ﻿INSERT INTO users (id, firstname, lastname, age) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23); nested exception is org.h2.jdbc.JdbcSQLException: Syntax error in SQL statement "﻿INSERT[*] INTO USERS (ID, FIRSTNAME, LASTNAME, AGE) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) "; SQL statement:
	    INSERT INTO users (id, firstname, lastname, age) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) [42000-192]
	at org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript(ScriptUtils.java:494)
	at org.springframework.jdbc.datasource.init.ResourceDatabasePopulator.populate(ResourceDatabasePopulator.java:231)
	at org.springframework.jdbc.datasource.init.DatabasePopulatorUtils.execute(DatabasePopulatorUtils.java:48)
	at org.springframework.boot.autoconfigure.jdbc.DataSourceInitializer.runScripts(DataSourceInitializer.java:157)
	at org.springframework.boot.autoconfigure.jdbc.DataSourceInitializer.runDataScripts(DataSourceInitializer.java:114)
	at org.springframework.boot.autoconfigure.jdbc.DataSourceInitializer.onApplicationEvent(DataSourceInitializer.java:107)
	at org.springframework.boot.autoconfigure.jdbc.DataSourceInitializer.onApplicationEvent(DataSourceInitializer.java:47)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:166)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:138)
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:381)
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:335)
	at org.springframework.boot.autoconfigure.orm.jpa.DataSourceInitializedPublisher.postProcessAfterInitialization(DataSourceInitializedPublisher.java:70)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization(AbstractAutowireCapableBeanFactory.java:422)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.postProcessObjectFromFactoryBean(AbstractAutowireCapableBeanFactory.java:1723)
	at org.springframework.beans.factory.support.FactoryBeanRegistrySupport.getObjectFromFactoryBean(FactoryBeanRegistrySupport.java:113)
	... 57 more

	Caused by: org.h2.jdbc.JdbcSQLException: Syntax error in SQL statement "﻿INSERT[*] INTO USERS (ID, FIRSTNAME, LASTNAME, AGE) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) "; SQL statement:
	    INSERT INTO users (id, firstname, lastname, age) VALUES (1, 'john', 'doe', 34), (2, 'jane', 'smith', 44), (3, 'robert', 'strike', 23) [42000-192]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:345)
	at org.h2.message.DbException.get(DbException.java:179)
	at org.h2.message.DbException.get(DbException.java:155)
	at org.h2.message.DbException.getSyntaxError(DbException.java:191)
	at org.h2.command.Parser.getSyntaxError(Parser.java:530)
	at org.h2.command.Parser.parsePrepared(Parser.java:488)
	at org.h2.command.Parser.parse(Parser.java:317)
	at org.h2.command.Parser.parse(Parser.java:293)
	at org.h2.command.Parser.prepareCommand(Parser.java:254)
	at org.h2.engine.Session.prepareLocal(Session.java:560)
	at org.h2.engine.Session.prepareCommand(Session.java:501)
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1202)
	at org.h2.jdbc.JdbcStatement.executeInternal(JdbcStatement.java:170)
	at org.h2.jdbc.JdbcStatement.execute(JdbcStatement.java:158)
	at org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript(ScriptUtils.java:473)

## Installation

Using Maven.

mvn clean install

mvn spring-boot:run
