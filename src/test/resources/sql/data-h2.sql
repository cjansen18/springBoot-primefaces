
/*TRUNCATE TABLE CFGSVC_ENVIRONMENT;
SELECT CFGSVC_ENVIRONMENT_SEQ.nextval from DUAL;
Insert into table id as: CFGSVC_ENVIRONMENT_SEQ.currval
*/
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (223, 'ParLoanInv', 'active', 'false', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (224, 'ParLoanInv', 'visible', 'true', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (225, 'ParLoanInv', 'separator', '|', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (226, 'ParLoanInv', 'data_type', 'FILE', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (227, 'ParLoanInv', 'data_source_prefix', '\\WPVWA00A0049\Reports\FIQ', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (228, 'ParLoanInv', 'data_source_suffix', '.dat', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (229, 'ParLoanInv', 'data_source_date_format', 'MM-dd-yyyy', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (230, 'ParLoanInv', 'display_name', 'Par Loan Inv', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (255, 'ParLoanInv', 'file_filter', 'Risk Inventory*', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (263, 'ParLoanInv', 'business_date_field_remove', 'maturity_Date', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (264, 'ParLoanInv', 'unique_desc_attribute', 'trading_Book_Name', '2014-06-17 10:00:12');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (356, 'ParLoanInv', 'is_loaded_sod', 'true', '2014-05-05 11:23:52');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (573, 'ParLoanInv', 'business_date_in_filename', 'true', '2014-08-21 18:06:16');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (590, 'ParLoanInv', 'business_date_prefix', 'Risk Inventory', '2014-08-21 18:06:16');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (592, 'ParLoanInv', 'business_date_attribute', 'captureDate', '2014-08-15 11:23:32');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (1135, 'ParLoanInv', 'is_single_file_source', 'true', '2015-02-04 15:28:34');
insert into px_dataset_props (prop_id, data_set, property_name, property_value, updateTime) values (1234, 'ParLoanInv', 'latest_date', 'today', '2015-03-16 10:36:30');

insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (354, 'ParLoanInv', 'Issuer', 'Issuer', 'java.lang.String', '', 150, 'COVERED', 'true', 'issuer', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (355, 'ParLoanInv', 'Industry', 'Industry', 'java.lang.String', '', 250, 'COVERED', 'true', 'industry', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (356, 'ParLoanInv', 'Issuer Moody', 'Issuer_Moody', 'java.lang.String', '', 150, 'COVERED', 'true', 'issuer_Moody', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (357, 'ParLoanInv', 'Issuer S&P', 'Issuer_S&P', 'java.lang.String', '', 150, 'COVERED', 'true', 'issuer_SP', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (358, 'ParLoanInv', 'Facility Name', 'Facility_Name', 'java.lang.String', '', 150, 'COVERED', 'true', 'facility_Name', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (359, 'ParLoanInv', 'Maturity Date', 'Maturity_Date', 'java.util.Date', 'MM/dd/yyyy', 150, 'COVERED', 'true', 'maturity_Date', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (360, 'ParLoanInv', 'Facility Moody', 'Facility_Moody', 'java.lang.String', '', 150, 'COVERED', 'true', 'facility_Moody', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (361, 'ParLoanInv', 'Facility S&P', 'Facility_S&P', 'java.lang.String', '', 150, 'COVERED', 'true', 'facility_SP', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (362, 'ParLoanInv', 'Libor Spread', 'Libor_Spread', 'java.lang.Double', 'N', 150, 'COVERED', 'true', 'libor_Spread', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (363, 'ParLoanInv', 'Trade Position', 'Trade_Position', 'java.lang.Double', 'N', 150, '', 'true', 'trade_Position', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (364, 'ParLoanInv', 'Last Mark', 'Last_Mark', 'java.lang.Double', 'N', 100, 'SUM', 'true', 'last_Mark', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (365, 'ParLoanInv', 'Researcher', 'Researcher', 'java.lang.String', '', 150, 'COVERED', 'true', 'researcher', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (366, 'ParLoanInv', 'Trader', 'Trader', 'java.lang.String', '', 150, 'COVERED', 'true', 'trader', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (367, 'ParLoanInv', 'Trading Book Name', 'Trading_Book_Name', 'java.lang.String', '', 250, 'COVERED', 'true', 'trading_Book_Name', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (368, 'ParLoanInv', '', 'list', 'java.util.ArrayList', '', 150, '', 'false', 'list', null, '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (1401, 'ParLoanInv', 'Primary Borrower CID Id', 'Primary_Borrower_CID', 'java.lang.String', '', 150, 'COVERED', 'true', 'primary_Borrower_CID_Id', '2014-08-11 11:02:55', '', null);
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (1402, 'ParLoanInv', 'Primary Borrower SCI ID', 'Primary_Borrower_SCI_ID', 'java.lang.String', '', 150, 'COVERED', 'true', 'primary_Borrower_SCI_ID', '2014-08-11 11:02:55', '', null);
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (1403, 'ParLoanInv', 'Capture Date', 'captureDate', 'java.util.Date', 'yyyyMMdd', 150, '', 'true', 'captureDate', '2014-08-15 11:23:32', '', '');
insert into px_attribute (id, data_set, display_name, source_name, type, format, col_size, group_action, col_visible, px_attr_name, updateTime, formula, historic) values (1413, 'ParLoanInv', 'Settled Position', 'Settled_Position', 'java.lang.Double', 'N', 150, 'COVERED', 'true', 'settledPosition', '2014-08-26 14:06:14', '', '');

