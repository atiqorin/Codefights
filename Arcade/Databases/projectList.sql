CREATE PROCEDURE projectList()
	SELECT Projects.project_name, Projects.team_lead, Projects.income FROM Projects ORDER BY Projects.internal_id;