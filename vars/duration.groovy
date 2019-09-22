import com.atlassian.jira.component.ComponentAccessor
import com.atlassian.jira.event.type.EventDispatchOption

def today = new Date()
def startDate = today.format("MMM dd H:m:s yyyy")
def endDate = expiryDateStr.format("MMM dd H:m:s yyyy")

def cfm = ComponentAccessor.customFieldManager
def issueManager = ComponentAccessor.issueManager

def startDate = cfm.getCustomFieldObjectByName("Start Date CF Name")
def endDate = cfm.getCustomFieldObjectByName("End Date CF Name")
def days = cfm.getCustomFieldObjectByName("Days")

def issueStartDate = issue.getCustomFieldValue(startDate) as Date
def issueEndDate = issue.getCustomFieldValue(endDate) as Date

def duration
use(groovy.time.TimeCategory) {
    duration = (issueEndDate - issueStartDate).days
}

issue.setCustomFieldValue(days,duration)
issueManager.updateIssue(ComponentAccessor.jiraAuthenticationContext.loggedInUser, issue, EventDispatchOption.DO_NOT_DISPATCH, false)

