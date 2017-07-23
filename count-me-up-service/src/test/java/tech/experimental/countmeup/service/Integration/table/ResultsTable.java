package tech.experimental.countmeup.service.Integration.table;

/**
 * The votes distribution table used for input to integration test
 */
public class ResultsTable
{
    private final String candidate;
    private final int percentage;
    private final long count;

    public ResultsTable(final String candidate, final int percentage, final long count)
    {
        this.candidate = candidate;
        this.percentage = percentage;
        this.count = count;
    }

    public String getCandidate()
    {
        return candidate;
    }

    public int getPercentage()
    {
        return percentage;
    }

    public long getCount()
    {
        return count;
    }
}
