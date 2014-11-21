package net.bytebuddy.matcher;

import net.bytebuddy.utility.MockitoRule;
import net.bytebuddy.utility.ObjectPropertyAssertion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public abstract class AbstractElementMatcherTest<T extends ElementMatcher<?>> {

    @Rule
    public TestRule mockitoRule = new MockitoRule(this);

    private final Class<? extends T> type;

    private final String startsWith;

    protected AbstractElementMatcherTest(Class<? extends T> type, String startsWith) {
        this.type = type;
        this.startsWith = startsWith;
    }

    @Test
    public void testObjectProperties() throws Exception {
        ObjectPropertyAssertion.of(type).specificToString(makeRegex(startsWith)).apply();
    }

    protected String makeRegex(String startsWith) {
        return "^" + startsWith + "\\(.*\\)$";
    }
}