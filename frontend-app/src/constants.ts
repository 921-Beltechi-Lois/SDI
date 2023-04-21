// export const  BACKEND_API_URL = "/api";

// const PROD_BACKEND_API_URL = "https://sdi-2023-example.strangled.net/api";

const PROD_BACKEND_API_URL = "https://sdi-mpp-project.jumpingcrab.com/api";
const DEV_BACKEND_API_URL = "http://localhost:8080/api";

export const BACKEND_API_URL =
	process.env.NODE_ENV === "development" ? DEV_BACKEND_API_URL : PROD_BACKEND_API_URL;
