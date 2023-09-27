true &&
  describe("Login Signup popups working", () => {
    it("redirects to login", () => {
      cy.visit("http://localhost:3000/");
      cy.contains("Go out for a meal").click();
      cy.url().should("contain", "login");
    });

    it("login with mail id", () => {
      cy.get("[name='email'").type("abhilash@gmail.com");
      cy.get("[name='password'").type("Password123");
      cy.get("[data-testid='button']").click();
      cy.get("[data-testid='logoutButton']");
    });

    it("logout buttton words", () => {
      cy.get("[data-testid='logoutButton']").click();
    });

    it("login button works", () => {
      cy.get("[data-testid='loginButton']").click();
      cy.get("[data-testid='close'").click();
    });

    it("signup button works", () => {
      cy.get("[data-testid='signupButton']").click();
      cy.get("[data-testid='close'").click();
    });
  });

true &&
  describe("ViewTypeItem, Collections, PopularCities redirects", () => {
    it("successfull", () => {
      cy.visit("http://localhost:3000/");
      cy.get("[data-testid='loginButton']").click();
      cy.get("[name='email'").type("abhilash@gmail.com");
      cy.get("[name='password'").type("Password123");
      cy.get("[data-testid='button']").click();
      cy.wait(3000);
      cy.contains("Order Food Online").scrollIntoView().should("be.visible");
      cy.contains("Order Food Online").click();
      cy.url().should("eq", "http://localhost:3000/viewType/delivery");
      cy.go("back");
      cy.contains("Trending This Week").scrollIntoView().should("be.visible");
      cy.contains("Trending This Week").click();
      cy.url().should("eq", "http://localhost:3000/collections");
      cy.go("back");
      cy.contains("Jubilee Hills").scrollIntoView().should("be.visible");
      cy.contains("Jubilee Hills").click();
      cy.url().should("eq", "http://localhost:3000/viewType/delivery");
    });
  });

true &&
  describe("apply filters", () => {
    it("successfull", () => {
      cy.visit("http://localhost:3000/");
      cy.get("[data-testid='loginButton']").click();
      cy.get("[name='email'").type("abhilash@gmail.com");
      cy.get("[name='password'").type("Password123");
      cy.get("[data-testid='button']").click();
      cy.wait(3000);
      cy.contains("Order Food Online").click();

      cy.get("[data-testid='sortBy']").click();
      cy.get("[data-value='rating']").click();

      cy.get("[data-testid='ratingFilter']").click();
      cy.contains("above 3").click();

      cy.get("[data-testid='costFilter']").click();
      cy.contains("min 200").click();
    });
  });
