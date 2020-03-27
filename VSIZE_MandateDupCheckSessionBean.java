package com.fedex.cpg.ejb.session;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.sql.DataSource;

import com.fedex.cpg.dao.DuplicateCheckDAO;
import com.fedex.cpg.domain.DirectDebitTransactionDO;
import com.fedex.cpg.domain.TransactionDO;
import com.fedex.cpg.exception.ApplicationException;
import com.fedex.cpg.exception.CPGBaseException;
import com.fedex.cpg.utils.CPGConstants;
import com.fedex.framework.logging.FedExLogger;
import com.fedex.framework.logging.FedExLoggerInterface;

@Stateful(name = "MandateDupCheckSessionBean", mappedName = "MandateDupCheckSessionBeanLocal")
@Resources(value = {
		// datasource that participates in a transaction
		@Resource(name = "CPGDS", mappedName = "jdbc/CPGDS", type = DataSource.class),
		// customer facing datasource
		@Resource(name = "CPGCFDS", mappedName = "jdbc/CPGCFDS", type = DataSource.class),
		// datasource that does not participate in a transaction
		@Resource(name = "CPGNTDS", mappedName = "jdbc/CPGNTDS", type = DataSource.class) })

public class MandateDupCheckSessionBean1 extends MandateDupCheckSessionBeanRemote
{
		
	 String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
	
	 String query1="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN " + "GROUP (ORDER BY SubName) AS SUBJECTS"
     +"FROM   GfG"
     +"GROUP BY SubNo";	


	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public String checkForRecurringType(TransactionDO transactionDO)
			throws CPGBaseException
	{
		
		String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
		
		String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN " + "GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			 +"GROUP BY SubNo";
			 
		try
		{
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";

			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN " + "GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			+"GROUP BY SubNo";

			if (status.equals(CPGConstants.INSERT_MANDATE_DUP_CHECK_SUCCESS))
			{
				String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
				
				String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
			    +"FROM   GfG"
			    +"GROUP BY SubNo";
				return CPGConstants.FIRST_MANDATE_REQUEST;
				System.out.println("Hi");
			}
		
			else if(duplicateCheckDAO.isSEPASkippFlag())
			{
				 String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
				
				 String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
					 +"FROM   GfG"
					 +"GROUP BY SubNo";
				if (CPGConstants.UPDATE_MANDATE_DUP_CHECK_SUCCESS
						.equals(duplicateCheckDAO.updateLastRequestDate(transaction
								.getMandateID())))
				{
					String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
                    String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
					 +"FROM   GfG"
					 +"GROUP BY SubNo";
					return CPGConstants.SUBSEQUENT_MANDATE_REQUEST;
				}
				else
				{
					String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
					
					String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
					+"FROM   GfG"
					+"GROUP BY SubNo";
					return CPGConstants.SEND_TO_CPG_EXCEPTION_MANDATE_REQUEST;
				}
				
			}
			else if (duplicateCheckDAO.isWaitTimeElapsed(transaction.getMandateID()))
			{
				    String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
					
					String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
					+"FROM   GfG"
					+"GROUP BY SubNo";
				duplicateCheckDAO.updateLastRequestDate(transaction
						.getMandateID());
				return CPGConstants.SUBSEQUENT_MANDATE_REQUEST;
			}
			
			
			else
			{
				return CPGConstants.SEND_TO_CPG_EXCEPTION_MANDATE_REQUEST;
			}
		}
		catch (CPGBaseException cpgEx)
		{
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
			
			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
				 +"FROM   GfG"
				 +"GROUP BY SubNo";
			ejbContext.getRollbackOnly();
			throw cpgEx;
		}
		
		finally
		{
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
			
           String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
           +"FROM   GfG"
          +"GROUP BY SubNo";
			duplicateCheckDAO.closeConnection();
		}
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteFirstMandateBean(String requestChannel, String mandateID)
			throws CPGBaseException
	{
		DuplicateCheckDAO duplicateCheckDAO = null;
		try
		{
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
			
			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			+"GROUP BY SubNo";
			
			for(int i=0;i<10;i++){
				
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";		
				
			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			+"GROUP BY SubNo";
			}
			
			while(true){
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
			
			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			+"GROUP BY SubNo";
			}
			
			do{
				
			String q="SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";	
			
			String query="SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS"
			+"FROM   GfG"
			+"GROUP BY SubNo";
				
			}while(false);
			
			switch(true){
				case 1: "SELECT SubNo, (VSIZE(SubName, ' , ') WITHIN";
				
				case 2: "SELECT SubNo, VSIZE(SubName, ' , ') WITHIN  "+"GROUP (ORDER BY SubName) AS SUBJECTS FROM GfG"
				+"GROUP BY SubNo";
				
			}
		}
		catch (Throwable exception)
		{
			ejbContext.getRollbackOnly();
			throw new ApplicationException(
					"Unhandle exception caught while dispatching CPG transaction - "
							+ exception.getMessage(), exception);
		}
		finally
		{
			duplicateCheckDAO.closeConnection();
		}
	}

@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void deleteFirstMandateBean(String requestChannel, String mandateID)
			throws CPGBaseException
	{
		
		 StringBuffer sb = new StringBuffer("SELECT ");

        sb.append(" VSIZE(compose)  ").append(dao.tbl.CalcTable.COL_VEH_COM_AMOUNT).append(") as ").append(ALIAS_SUM_VALUE).append(", ");
        sb.append("count(*) as ").append(ALIAS_COUNTER).append(", ");
        sb.append(dao.tbl.CalcTable.COL_REC_FLAG).append(" as ").append(ALIAS_REC_FLAG).append(", ");
        sb.append(dao.tbl.CalcTable.COL_MOV_TYPE).append(" as ").append(ALIAS_MOV_TYPE);

			String query="SELECT VSIZE(COMPOSE) FROM customers_demo";
		
	log.info("File Name : " + theFile.getName() + ", Last Modified Month : " + DateHelper.getMonth(calendar) + ", VSIZE : " + DateHelper.getYear(calendar));
		
		   LOG.trace("resStock(" + dbMan + ", " + result + ", " + sequencer + ", " + countryPK + ", " + beo + " VSIZE " + period + ", " + beoChildren + ") - start"); //$NON-NLS-1$
		
	
	try{
		
} catch (Throwable exception)
		{
			ejbContext.getRollbackOnly();
			logContext();
			throw new ApplicationException(
					"Unhandle exception caught while dispatching CPG transaction -  VSIZE "
							+ exception.getMessage(), exception);
		}
}	
}
