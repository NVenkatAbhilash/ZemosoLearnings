import React from "react";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import "@testing-library/jest-dom";
import HomeView from "./HomeView";
import renderer from "react-test-renderer";
import { render, fireEvent, cleanup } from "@testing-library/react";

afterEach(cleanup);

it("renders HomeView snapshot correctly", () => {
  const location = {
    hash: false,
    search: "something",
  };
  const tree = renderer
    .create(
      <BrowserRouter>
        <HomeView location={location} />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders HomeView without crashing", () => {
  const location = {
    hash: false,
    search: "something",
  };
  const div = document.createElement("div");
  ReactDOM.render(
    <BrowserRouter>
      <HomeView location={location} />
    </BrowserRouter>,
    div
  );
});

it("renders HomeView correctly when loggedIn", () => {
  const location = {
    hash:
      "http://localhost:3000/#access_token=xsgjv5N_IJfW-huFLtiTJ-bogWn1BZCv&scope=openid%20profile%20email&expires_in=7200&token_type=Bearer&state=6CCIcBbVABI-L-560wtMm.Gwj7IAIYP0&id_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IllLYWMwNzhwWDBvSnJFSUwwbkRTcCJ9.eyJnaXZlbl9uYW1lIjoiQWJoaWxhc2giLCJmYW1pbHlfbmFtZSI6Ik5vdGxhIiwibmlja25hbWUiOiJhYmhpbGFzaC5ub3RsYSIsIm5hbWUiOiJBYmhpbGFzaCBOb3RsYSIsInBpY3R1cmUiOiJodHRwczovL2xoNS5nb29nbGV1c2VyY29udGVudC5jb20vLXVvN0drMVByVnkwL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FNWnV1Y2xvZ2YtRWd3YkNwMlEzQTBpYnJXbWtPUnlhTXcvczk2LWMvcGhvdG8uanBnIiwibG9jYWxlIjoiZW4iLCJ1cGRhdGVkX2F0IjoiMjAyMS0wMS0yMFQxMjozNDoxNy45NzhaIiwiZW1haWwiOiJhYmhpbGFzaC5ub3RsYUB6ZW1vc29sYWJzLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJpc3MiOiJodHRwczovL2Rldi0wNnNwajl4ci51cy5hdXRoMC5jb20vIiwic3ViIjoiZ29vZ2xlLW9hdXRoMnwxMDAxNzE3OTExNTc3NDk1NjkxNDUiLCJhdWQiOiJkYVloa0dqajQyMDVFRkR3Q2dQcFR0QjdUb2t6U0FwUiIsImlhdCI6MTYxMTE0NjA1OCwiZXhwIjoxNjExMTgyMDU4LCJhdF9oYXNoIjoiWlVZeDNPV2Zndm14MTdQeTBjaXlPQSIsIm5vbmNlIjoibGl5S21nT1U4aTE4OG50OUZFc2RoQ0lfMk9WTThqUzYifQ.URlzhdedukbWQR7VySxVD1-emYsoq7yT-2ZQoPw-gBiT-gZyQSl4HYW46CtPqfDBBd5AWIqe1ssydvUX_YgalAWZ9M1ekwnIDgwH1Aq16O-tMsSyI5cdMo6WDrhFW6VaPPZoqXgtdIJi3GHu3UNckCr3R08wloRomOBPnvxEuLUBpUpGcBNCObE4Mv-22se5mcbGkGTTu7VEzk7zPIlyUBQKUs-82QKHSE8WFo4lV0z-aeJ-VgIScD0dzNPTKlfQcDPPF2TIAuWLVEnPXYskpvN1mckUGS3SbUTVIMs6LV3zXX1mPPoeW8ehogzw-kUboqiG1I3o85sOrMfDPsEv1Q",
    search:
      "http://localhost:3000/#access_token=xsgjv5N_IJfW-huFLtiTJ-bogWn1BZCv&scope=openid%20profile%20email&expires_in=7200&token_type=Bearer&state=6CCIcBbVABI-L-560wtMm.Gwj7IAIYP0&id_token=eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IllLYWMwNzhwWDBvSnJFSUwwbkRTcCJ9.eyJnaXZlbl9uYW1lIjoiQWJoaWxhc2giLCJmYW1pbHlfbmFtZSI6Ik5vdGxhIiwibmlja25hbWUiOiJhYmhpbGFzaC5ub3RsYSIsIm5hbWUiOiJBYmhpbGFzaCBOb3RsYSIsInBpY3R1cmUiOiJodHRwczovL2xoNS5nb29nbGV1c2VyY29udGVudC5jb20vLXVvN0drMVByVnkwL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FNWnV1Y2xvZ2YtRWd3YkNwMlEzQTBpYnJXbWtPUnlhTXcvczk2LWMvcGhvdG8uanBnIiwibG9jYWxlIjoiZW4iLCJ1cGRhdGVkX2F0IjoiMjAyMS0wMS0yMFQxMjozNDoxNy45NzhaIiwiZW1haWwiOiJhYmhpbGFzaC5ub3RsYUB6ZW1vc29sYWJzLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJpc3MiOiJodHRwczovL2Rldi0wNnNwajl4ci51cy5hdXRoMC5jb20vIiwic3ViIjoiZ29vZ2xlLW9hdXRoMnwxMDAxNzE3OTExNTc3NDk1NjkxNDUiLCJhdWQiOiJkYVloa0dqajQyMDVFRkR3Q2dQcFR0QjdUb2t6U0FwUiIsImlhdCI6MTYxMTE0NjA1OCwiZXhwIjoxNjExMTgyMDU4LCJhdF9oYXNoIjoiWlVZeDNPV2Zndm14MTdQeTBjaXlPQSIsIm5vbmNlIjoibGl5S21nT1U4aTE4OG50OUZFc2RoQ0lfMk9WTThqUzYifQ.URlzhdedukbWQR7VySxVD1-emYsoq7yT-2ZQoPw-gBiT-gZyQSl4HYW46CtPqfDBBd5AWIqe1ssydvUX_YgalAWZ9M1ekwnIDgwH1Aq16O-tMsSyI5cdMo6WDrhFW6VaPPZoqXgtdIJi3GHu3UNckCr3R08wloRomOBPnvxEuLUBpUpGcBNCObE4Mv-22se5mcbGkGTTu7VEzk7zPIlyUBQKUs-82QKHSE8WFo4lV0z-aeJ-VgIScD0dzNPTKlfQcDPPF2TIAuWLVEnPXYskpvN1mckUGS3SbUTVIMs6LV3zXX1mPPoeW8ehogzw-kUboqiG1I3o85sOrMfDPsEv1Q",
  };
  localStorage.setItem(
    "id_token",
    "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IllLYWMwNzhwWDBvSnJFSUwwbkRTcCJ9.eyJnaXZlbl9uYW1lIjoiQWJoaWxhc2giLCJmYW1pbHlfbmFtZSI6Ik5vdGxhIiwibmlja25hbWUiOiJhYmhpbGFzaC5ub3RsYSIsIm5hbWUiOiJBYmhpbGFzaCBOb3RsYSIsInBpY3R1cmUiOiJodHRwczovL2xoNS5nb29nbGV1c2VyY29udGVudC5jb20vLXVvN0drMVByVnkwL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUFBL0FNWnV1Y2xvZ2YtRWd3YkNwMlEzQTBpYnJXbWtPUnlhTXcvczk2LWMvcGhvdG8uanBnIiwibG9jYWxlIjoiZW4iLCJ1cGRhdGVkX2F0IjoiMjAyMS0wMS0yMFQxMjozNDoxNy45NzhaIiwiZW1haWwiOiJhYmhpbGFzaC5ub3RsYUB6ZW1vc29sYWJzLmNvbSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJpc3MiOiJodHRwczovL2Rldi0wNnNwajl4ci51cy5hdXRoMC5jb20vIiwic3ViIjoiZ29vZ2xlLW9hdXRoMnwxMDAxNzE3OTExNTc3NDk1NjkxNDUiLCJhdWQiOiJkYVloa0dqajQyMDVFRkR3Q2dQcFR0QjdUb2t6U0FwUiIsImlhdCI6MTYxMTE0NjA1OCwiZXhwIjoxNjExMTgyMDU4LCJhdF9oYXNoIjoiWlVZeDNPV2Zndm14MTdQeTBjaXlPQSIsIm5vbmNlIjoibGl5S21nT1U4aTE4OG50OUZFc2RoQ0lfMk9WTThqUzYifQ.URlzhdedukbWQR7VySxVD1-emYsoq7yT-2ZQoPw-gBiT-gZyQSl4HYW46CtPqfDBBd5AWIqe1ssydvUX_YgalAWZ9M1ekwnIDgwH1Aq16O-tMsSyI5cdMo6WDrhFW6VaPPZoqXgtdIJi3GHu3UNckCr3R08wloRomOBPnvxEuLUBpUpGcBNCObE4Mv-22se5mcbGkGTTu7VEzk7zPIlyUBQKUs-82QKHSE8WFo4lV0z-aeJ-VgIScD0dzNPTKlfQcDPPF2TIAuWLVEnPXYskpvN1mckUGS3SbUTVIMs6LV3zXX1mPPoeW8ehogzw-kUboqiG1I3o85sOrMfDPsEv1Q"
  );
  const tree = renderer
    .create(
      <BrowserRouter>
        <HomeView location={location} />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders HomeView correctly when not logged in", () => {
  const location = {
    hash: false,
    search: "http://localhost:3000/?login",
  };
  localStorage.removeItem("id_token");
  const tree = renderer
    .create(
      <BrowserRouter>
        <HomeView location={location} />
      </BrowserRouter>
    )
    .toJSON();
  expect(tree).toMatchSnapshot();
});

it("renders HomeView Login button correctly ", () => {
  const location = {
    hash: false,
    search: "http://localhost:3000/?login",
  };
  const { getByTestId } = render(
    <BrowserRouter>
      <HomeView location={location} />
    </BrowserRouter>
  );
  fireEvent.click(getByTestId("loginButton"));
});

it("renders HomeView Signup button correctly ", () => {
  const location = {
    hash: false,
    search: "http://localhost:3000/?login",
  };
  const { getByTestId } = render(
    <BrowserRouter>
      <HomeView location={location} />
    </BrowserRouter>
  );
  fireEvent.click(getByTestId("signupButton"));
});