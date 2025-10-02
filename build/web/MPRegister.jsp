<%@ include file="MPBanner.jsp" %>
<section>
    <h1>Register</h1>
    <form action="MPDisplayMember.jsp" method="POST">

        <div class="form-container">

            <label for="fullname">Full Name:</label>
            <input type="text" id="fullname" name="fullname" style="width:300px;" required>
        </div>        
        <div class="form-container">

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" style="width:300px;" required>
        </div>
        
          <div class="form-container">

            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" style="width:300px;" required>
        </div>
        

        <div class="form-container">

            <label for="program">IT Program:</label>
            <select id="program" name="program">
                <option value="CAS">CAS</option>
                <option value="SQATE">SQATE</option>
                <option value="CPA">CPA</option>
                <option value="CP">CP</option>
                <option value="ITID">ITID</option>
                <option value="CAD">CAD</option>
                <option value="ITSS">ITSS</option>
            </select>
        </div>

        <div class="form-container">

            <label for="year">Year:</label>
            <select id="year" name="year">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
        </div>

        <br>
        <button type="submit">Register Now!</button>
        <button type="reset">Reset</button>
    </form>
</section>
<%@ include file="MPFooter.jsp" %>