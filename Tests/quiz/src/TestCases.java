import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

import org.junit.*;

public class TestCases {

    /**
     * Tests if all class field are private, protected
     * or package-protected. You don't have to understand
     * this code.
     * @param classes classes to be tested.
     */
    private void fieldsArentPublic(Class<?> ... classes) {
        for (Class<?> c: classes)
            for (Field f : c.getDeclaredFields())
                assertFalse(Modifier.isPublic(f.getModifiers()));
    }

    /**
     * Tests if a class is abstract. You don't have to 
     * understand this code.
     * @param c class to be tested.
     */
    private void isAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }

/*
    @Test
    public void testActs() {
        Act radiohead = new Band("Radiohead", "UK");
        Act bob = new Artist("Bob Dylan", "USA");

        assertEquals("Radiohead", radiohead.getName());
        assertEquals("UK", radiohead.getCountry());

        assertEquals("Bob Dylan", bob.getName());
        assertEquals("USA", bob.getCountry());

        // Make sure your fields aren't public
        fieldsArentPublic(Artist.class);
        fieldsArentPublic(Band.class);

        // Make sure your Act class is abstract
        isAbstract(Act.class);
    }



    @Test
    public void testConcert() {
        Band radiohead = new Band("Radiohead", "UK");
        Artist bob = new Artist("Bob Dylan", "USA");

        Concert concert = new Concert("London", "UK", "2019/10/10");
        concert.addAct(radiohead);
        concert.addAct(bob);

        List<Act> acts = concert.getActs();
        assertEquals(2, acts.size());
        assertEquals("London", concert.getCity());
        assertEquals("UK", concert.getCountry());
        assertEquals("2019/10/10", concert.getDate());

        fieldsArentPublic(Concert.class);
    }



    @Test
    public void testEquals() {
        Concert concert1 = new Concert("Paris", "France", "2019/10/10");
        Concert concert2 = new Concert("Paris", "USA", "2019/10/10");

        assertNotEquals(concert1, concert2);

        Concert concert3 = new Concert("New York", "USA", "2019/10/10");
        assertNotEquals(concert2, concert3);

        Concert concert4 = new Concert("New York", "USA", "2019/05/20");
        assertNotEquals(concert3, concert4);

        Concert concert5 = new Concert("New York", "USA", "2019/05/20");
        assertEquals(concert4, concert5);
    }



    @Test 
    public void testSet() {
        Concert concert1 = new Concert("Paris", "France", "2019/10/10");
        Concert concert2 = new Concert("Paris", "USA", "2019/10/10");
        Concert concert3 = new Concert("New York", "USA", "2019/10/10");
        Concert concert4 = new Concert("New York", "USA", "2019/05/20");
        Concert concert5 = new Concert("New York", "USA", "2019/05/20");

        Set<Concert> tour = new HashSet<>();
        tour.add(concert1);
        tour.add(concert2);
        tour.add(concert3);
        tour.add(concert4);
        tour.add(concert5);

        assertEquals(4, tour.size());
    }



    @Test
    public void testTicket() throws InvalidTicket {
        Concert concert = new Concert("London", "UK", "2019/10/10");
        Concert nextDayConcert = new Concert("London", "UK", "2019/10/11");
        Ticket ticket = new Ticket(1234, concert);

        assertEquals(1234, ticket.getNumber());
        assertEquals(concert, ticket.getConcert());

        // isValid checks if ticket is for the correct concert
        assertTrue(concert.isValid(ticket));
        assertFalse(nextDayConcert.isValid(ticket));

        fieldsArentPublic(Ticket.class);
    }




    // This test expects the code to throw an InvalidTicket exception
    @Test(expected = InvalidTicket.class)
    public void testInvalidTicket() throws InvalidTicket {
        Concert concert = new Concert("London", "UK", "2019/10/10");
        Ticket ticket = new Ticket(-1, concert);
    }



    @Test
    public void testBandArtists() {
        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        List<Artist> artists = radiohead.getArtists();
        assertEquals(artists.get(0).getName(), "Thom Yorke");
        assertEquals(artists.get(1).getName(), "Jonny Greenwood");
        assertEquals(artists.get(2).getName(), "Colin Greenwood");
        assertEquals(artists.get(3).getName(), "Philip Selway");
        assertEquals(artists.get(4).getName(), "Ed O'Brien");
        
        assertEquals(5, artists.size());
    }



    @Test
    public void testContains() {
        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        assertTrue(thom.equals(new Artist("Thom Yorke", "UK")));

        assertTrue(radiohead.containsArtist(new Artist("Thom Yorke", "UK")));
        assertFalse(radiohead.containsArtist(new Artist("Thom Yorke", "USA")));
        assertFalse(radiohead.containsArtist(new Artist("Tom Yorke", "UK")));
    }



    @Test
    public void testParticipates() {
        Concert concert = new Concert("London", "UK", "2019/10/10");

        Band radiohead = new Band("Radiohead", "UK");

        Artist thom = new Artist("Thom Yorke", "UK");
        Artist jonny = new Artist("Jonny Greenwood", "UK");
        Artist colin = new Artist("Colin Greenwood", "UK");
        Artist philip = new Artist("Philip Selway", "UK");
        Artist ed = new Artist("Ed O'Brien", "UK");

        radiohead.addArtist(thom);
        radiohead.addArtist(jonny);
        radiohead.addArtist(colin);
        radiohead.addArtist(philip);
        radiohead.addArtist(ed);

        concert.addAct(radiohead);

        Artist bob = new Artist("Bob Dylan", "USA");
        concert.addAct(bob);

        // Concert.participates only needs to work for artists
        assertTrue(concert.participates(new Artist("Bob Dylan", "USA")));
        assertTrue(concert.participates(new Artist("Thom Yorke", "UK")));

        assertFalse(concert.participates(new Artist("Bob Dylan", "UK")));
        assertFalse(concert.participates(new Artist("Thom Yorke", "USA")));
        assertFalse(concert.participates(new Artist("Bob the Builder", "USA")));
        assertFalse(concert.participates(new Artist("Tom Tom", "UK")));
    }



    @Test
    public void testBoxOffice() throws InvalidTicket {
        Act bob = new Artist("Bob Dylan", "USA");
        Band radiohead = new Band("Radiohead", "UK");

        Concert concertLondon = new Concert("London", "UK", "2019/10/10");
        concertLondon.addAct(bob);

        Concert concertParis = new Concert("Paris", "France", "2019/05/20");
        concertParis.addAct(bob);
        concertParis.addAct(radiohead);

        // Buying three tickets for the London concert
        List<Ticket> tickets1 = BoxOffice.buy(concertLondon, 3);
        // Buying three tickets for the Paris concert
        List<Ticket> tickets2 = BoxOffice.buy(concertParis, 3);
        // Buying three more tickets for the London concert
        List<Ticket> tickets3 = BoxOffice.buy(concertLondon, 3);

        assertEquals(1, tickets1.get(0).getNumber());
        assertEquals(2, tickets1.get(1).getNumber());
        assertEquals(3, tickets1.get(2).getNumber());

        assertEquals(4, tickets3.get(0).getNumber());
        assertEquals(5, tickets3.get(1).getNumber());
        assertEquals(6, tickets3.get(2).getNumber());

        assertEquals(tickets1.get(0).getConcert(), concertLondon);
        assertEquals(tickets2.get(0).getConcert(), concertParis);
        assertEquals(tickets3.get(0).getConcert(), concertLondon);
    }

*/
/*    // Auxiliary method used by some test methods (no need to understand the code!).
    private void fieldsArePrivateOrProtected(Class<?> ... classes) {
        for (Class<?> c: classes)
            for (Field f : c.getDeclaredFields())
                assertTrue(Modifier.isPrivate(f.getModifiers())
                        || Modifier.isProtected(f.getModifiers()));
    }

    // Auxiliary method used by some test methods (no need to understand the code!).
    private void classIsAbstract(Class<?> c) {
        assertTrue(Modifier.isAbstract(c.getModifiers()));
    }

    @Test
    public void testLogicVariable() {
        LogicVariable x1 = new LogicVariable("x1", false);
        assertEquals("x1", x1.getName());
        assertEquals(false, x1.getValue());
        x1.setValue(true);
        assertEquals(true, x1.getValue());
        fieldsArePrivateOrProtected(LogicVariable.class);
    }

    @Test
    public void testEquals() {
        LogicVariable a = new LogicVariable("y1");
        LogicVariable b = new LogicVariable("y1");
        assertTrue(a.equals(b)); // same name
        assertTrue(a.equals((Object)b));
    }

    @Test
    public void testLogicGates() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false); // input variable
        LogicVariable x2 = new LogicVariable("x2", false); // input variable
        LogicVariable x3 = new LogicVariable("x3", false); // input variable
        LogicVariable w1 = new LogicVariable("w1"); // 'internal' variable
        LogicVariable w2 = new LogicVariable("w2"); // 'internal' variable
        LogicVariable y1 = new LogicVariable("y1"); // output variable

        LogicGate p1 = new GateAnd(w1, x1, x2);
        assertSame(w1, p1.getOutput());
        assertTrue(Arrays.equals(new LogicVariable[]{x1, x2}, p1.getInputs()));

        LogicGate p2 = new GateOr(w2, w1, x3);
        assertSame(w2, p2.getOutput());
        assertTrue(Arrays.equals(new LogicVariable[]{w1, x3}, p2.getInputs()));

        LogicGate p3 = new GateNot(y1, w2);
        assertSame(y1, p3.getOutput());
        assertTrue(Arrays.equals(new LogicVariable[]{w2}, p3.getInputs()));

        fieldsArePrivateOrProtected(LogicGate.class, GateAnd.class, GateOr.class, GateNot.class);
        classIsAbstract(LogicGate.class);
    }

    @Test
    public void testSymbols() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false);
        LogicVariable x2 = new LogicVariable("x2", false);
        LogicVariable x3 = new LogicVariable("x3", false);
        LogicVariable w1 = new LogicVariable("w1");
        LogicVariable w2 = new LogicVariable("w2");
        LogicVariable y1 = new LogicVariable("y1");

        LogicGate p1 = new GateAnd(w1, x1, x2);
        assertEquals("AND", p1.getSymbol());

        LogicGate p2 = new GateOr(w2, w1, x3);
        assertEquals("OR", p2.getSymbol());

        LogicGate p3 = new GateNot(y1, w2);
        assertEquals("NOT", p3.getSymbol());

        fieldsArePrivateOrProtected(LogicGate.class, GateAnd.class, GateOr.class, GateNot.class);
        classIsAbstract(LogicGate.class);
    }

    @Test
    public void testCalculatedBy() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false);
        LogicVariable x2 = new LogicVariable("x2", false);
        LogicVariable y1 = new LogicVariable("y1");

        LogicGate p1 = new GateAnd(y1, x1, x2);

        assertSame(p1, y1.getCalculatedBy());
        assertSame(null, x1.getCalculatedBy());
        assertSame(null, x2.getCalculatedBy());
    }

    // A variable cannot be calculated by multiple gates
    @Test(expected = ColisionException.class)
    public void testColision() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false);
        LogicVariable x2 = new LogicVariable("x2", false);
        LogicVariable x3 = new LogicVariable("x3", false);
        LogicVariable x4 = new LogicVariable("x4", false);
        LogicVariable y1 = new LogicVariable("y1");

        LogicGate p1 = new GateAnd(y1, x1, x2);
        LogicGate p2 = new GateOr(y1, x3, x4);
    }

    @Test
    public void testFormulas() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false);
        LogicVariable x2 = new LogicVariable("x2", false);
        LogicVariable x3 = new LogicVariable("x3", false);
        LogicVariable w1 = new LogicVariable("w1");
        LogicVariable w2 = new LogicVariable("w2");
        LogicVariable y1 = new LogicVariable("y1");

        LogicGate p1 = new GateAnd(w1, x1, x2);
        LogicGate p2 = new GateOr(w2, w1, x3);
        LogicGate p3 = new GateNot(y1, w2);

        assertEquals("x1", x1.getFormula());
        assertEquals("NOT(OR(AND(x1,x2),x3))", y1.getFormula());
        assertEquals("NOT(OR(AND(x1,x2),x3))", p3.getFormula());
    }

    @Test
    public void testValues() throws Exception {
        LogicVariable x1 = new LogicVariable("x1", false);
        LogicVariable x2 = new LogicVariable("x2", true);
        LogicVariable x3 = new LogicVariable("x3", true);
        LogicVariable w1 = new LogicVariable("w1");
        LogicVariable w2 = new LogicVariable("w2");
        LogicVariable y1 = new LogicVariable("y1");

        LogicGate p1 = new GateAnd(w1, x1, x2);
        LogicGate p2 = new GateOr(w2, w1, x3);
        LogicGate p3 = new GateNot(y1, w2);

        assertEquals(false, x1.getValue());
        assertEquals(true, x2.getValue());
        assertEquals(true, x3.getValue());
        assertEquals(false, w1.getValue());
        assertEquals(true, w2.getValue());
        assertEquals(false, y1.getValue());

        x3.setValue(false);
        assertEquals(true, y1.getValue());
    }

    // Circular dependencies are not allowed
    @Test(expected = CycleException.class)
    public void testCycles() throws Exception {
        LogicVariable w1 = new LogicVariable("w1");
        LogicVariable w2 = new LogicVariable("w2");
        LogicVariable w3 = new LogicVariable("w3");

        LogicGate p1 = new GateAnd(w3, w2, w1);
        LogicGate p2 = new GateNot(w2, w3);
    }

    @Test
    public void testCombinatorialCircuit() {
        CombinatorialCircuit c = new CombinatorialCircuit();
        LogicVariable a = new LogicVariable("x1");
        LogicVariable b = new LogicVariable("x1");
        assertEquals(true, c.addVariable(a));
        assertEquals(false, c.addVariable(b)); // duplicate names are not allowed
        assertSame(a, c.getVariableByName("x1"));
        assertSame(null, c.getVariableByName("x2"));
    }*/
    @Test
    public void testBuilding() throws Exception {
        Building b = new Building("B", -1, 4);
        assertEquals("B", b.getName());
        assertEquals(-1, b.getMinFloor());
        assertEquals(4, b.getMaxFloor());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testBuildingArgs() throws Exception {
        Building b = new Building("B", 4, -1);
    }

    @Test
    public void testRoom() throws Exception {
        Building b = new Building("B", -1, 4);
        Room r = new Room(b, "104", 1);
        assertSame(b, r.getBuilding());
        assertEquals("104", r.getNumber());
        assertEquals("B104", r.getName());
        assertEquals(1, r.getFloor());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRoomArgs() throws Exception {
        Building b = new Building("B", -1, 4);
        Room r = new Room(b, "104", 5);
    }

    @Test
    public void testFacility() throws Exception {
        Facility b = new Building("B", -1, 4);
        Facility r = new Room((Building)b, "104", 1);
        assertEquals("B", b.getName());
        assertEquals("B104", r.getName());
    }

    @Test
    public void testUser() throws Exception {
        User u1 = new User("Rui");
        User u2 = new User("Maria");
        User u3 = new User("Rui");
        assertEquals("Rui", u1.getName());
        assertTrue(u1.equals(u3));
        assertFalse(u1.equals(u2));
    }

    @Test
    public void testToString() throws Exception {
        Building b = new Building("B", -1, 4);
        Room b104 = new Room(b, "104", 1);
        assertEquals("Building(B)", b + "");
        assertEquals("Room(B,104)", b104 + "");
    }

    @Test
    public void testCapacity() throws Exception {
        Building b = new Building("B", -1, 4);
        assertEquals(0, b.getCapacity());
        Room b104 = new Room(b, "104", 1, 69);
        assertEquals(69, b104.getCapacity());
        Room b208 = new Room(b, "208", 2, 52);
        Room b213 = new Room(b, "213", 2, 52);
        assertEquals(173, b.getCapacity());
    }

    @Test(expected = DuplicateRoomException.class)
    public void testDuplicateRooms() throws Exception {
        Building b = new Building("B", -1, 4);
        Room b1 = new Room(b, "104", 1);
        Room b2 = new Room(b, "104", 1);
    }

    @Test
    public void testUserAccess() throws Exception  {
        User u1 = new User("Rui");
        User u2 = new User("Maria");

        Facility b = new Building("B", -1, 4);
        Facility a = new Building("A", -1, 4);
        Room b104 = new Room((Building)b, "104", 1);
        Room a001 = new Room((Building)a, "001", 0);

        b104.authorize(u1);
        b104.authorize(u2);
        a001.authorize(u2);

        // A user is allowed to enter a room if he/she
        // was previously authorized
        assertTrue(b104.canEnter(u1) );
        assertTrue(b104.canEnter(u2) );
        assertFalse(a001.canEnter(u1) );
        assertTrue(a001.canEnter(u2) );

        // A user is allowed to enter a building if he/she
        // is authorized to enter a room in that building
        assertTrue(b.canEnter(u1));
        assertTrue(b.canEnter(u2));
        assertFalse(a.canEnter(u1));
        assertTrue(a.canEnter(u2));

        // All facilities have the "canEnter" method
        Facility f = b104;
        assertTrue(f.canEnter(u1));
    }
}