
<%@page import="com.sd.web.security.Ticket"%>
<%@page import="com.sd.web.enums.Roles"%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
<div >

		<ul class="sf-menu">
			<li class="current">
				<a href="articleDisplay.do?entityId=10">Home</a>

			</li>

			<%
				Ticket ticket = (Ticket) request.getSession().getAttribute("ticket");
				if (ticket != null && Roles.ADMIN.toString().equalsIgnoreCase(ticket.getRole())) {
			%>

			<li class="current">
				<a href="#">Services</a>
				<ul>
					<li>
						<a href="#">User</a>
						<ul>
							<li class="current">
								<a href="userRegistrationList.do">Add User</a>
							</li>
							<li>
								<a href="reSetPassword.do">Change Password</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="adminService.do">Admin</a>
						
					</li>
					<li>
						<a href="emailService.do">Gmail Service</a>
						
					</li>
					
				</ul>
			</li>

			<%
				}
			%>

			<li class="current">
				<a href="#">Java</a>
				<ul>
					<li>
						<a href="articleDisplay.do?entityId=100">J2SE</a>
					</li>
					<li>
						<a href="#">J2EE</a>
						<ul>
							<li class="current">
								<a href="articleDisplay.do?entityId=1010">Servlet</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=1011">JSP</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=1012">EJB</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#">FrameWork</a>
						<ul>
							<li class="current">
								<a href="articleDisplay.do?entityId=1020">Spring</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=1021">Struts</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=10210">Apache Wicket</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=1022">JSF</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=1023">Hibernate</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#">Content Management</a>
						<ul>
							<li class="current">
								<a href="articleDisplay.do?entityId=1030">Alfresco</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=1031">Liferay</a>
							</li>

						</ul>
					</li>

				</ul>
			</li>

			<li class="current">
				<a href="#">GUI</a>
				<ul>
					<li>
						<a href="articleDisplay.do?entityId=700">HTML</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=701">Java Script</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=702">JQuery</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=703">CSS</a>
					</li>
	
				</ul>
			</li>
			


			<li class="current">
				<a href="#">Database</a>
				<ul>
					<li>
						<a href="articleDisplay.do?entityId=200">DBA</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=201">PL/SQL</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=202">Form & Report</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=203">Data Warehousing</a>
					</li>

				</ul>
			</li>

			<li class="current">
				<a href="#">Interview QA</a>
				<ul>
					<li>
						<a href="#">Java</a>
						<ul>
							<li class="current">
								<a href="articleDisplay.do?entityId=3000">J2SE</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=3001">Servlet</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3002">JSP</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3003">EJB</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3004">Struts</a>
							</li>
							<li>
								<a href="articleDisplay.do?entityId=3005">JSF</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3006">Hibernate</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3007">Spring</a>
							</li>

							<li>
								<a href="articleDisplay.do?entityId=3008">JSF</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=300">DBA</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=301">PL/SQL</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=302">Form & Report</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=303">Data Warehousing</a>
					</li>
					<li>
						<a href="articleDisplay.do?entityId=304">Others</a>
					</li>

				</ul>
			</li>
			
			
			<li class="current">
				<a href="#">Self Test</a>
				<ul>
					<li>
						<a href="#">Java</a>
						<ul>
							<li class="current">
								<a href="objectiveQAList.do?entityId=4000">J2SE</a>
							</li>
							<li>
								<a href="objectiveQAList.do?entityId=4001">Servlet</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4002">JSP</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4003">EJB</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4004">Struts</a>
							</li>
							<li>
								<a href="objectiveQAList.do?entityId=4005">JSF</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4006">Hibernate</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4007">Spring</a>
							</li>

							<li>
								<a href="objectiveQAList.do?entityId=4008">JSF</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="objectiveQAList.do?entityId=400">DBA</a>
					</li>
					<li>
						<a href="objectiveQAList.do?entityId=401">PL/SQL</a>
					</li>
					<li>
						<a href="objectiveQAList.do?entityId=402">Form & Report</a>
					</li>
					<li>
						<a href="objectiveQAList.do?entityId=403">Data Warehousing</a>
					</li>
					<li>
						<a href="objectiveQAList.do?entityId=404">Others</a>
					</li>

				</ul>
			</li>
			
			
			
			<li class="current">
				<a href="articleDisplay.do?entityId=500">Projects</a>

			</li>
			
			<li class="current">
				<a href="#">Others</a>
				<ul>
				    <li class="current">
						<a href="articleDisplay.do?entityId=800">Android</a>
					</li>	
					<li>
						<a href="articleDisplay.do?entityId=801">JUnit</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=802">Ant</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=803">Maven</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=804">Log4J</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=805">Tools</a>
					</li>
					
					<li>
						<a href="articleDisplay.do?entityId=806">Domain Knowledge</a>
					</li>
					
					
				</ul>
			</li>
			
			
			<li class="current">
				<a href="articleDisplay.do?entityId=600">Contact Us</a>

			</li>
			
			
		</ul>
