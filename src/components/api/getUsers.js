import { domainName } from "./domainName";

const url = `${domainName()}/api/v1/user`;

const getUsers = async (url) => {
  const response = await fetch(url);
  const users = await response.json();

  const listPeople = users.map(
    ({ firstName, lastName, email }) => {
      return `
                <div class="col-lg-3 col-md-4 col-sm-5">
                    <div class="card m-2 rounded shadow-sm">
                        <div class="card-body"><strong>${firstName} ${lastName}</strong></div>
                        <div class="card-body">${email}</div>
                    </div>                
                </div>
            `;
    }
  );

  return listPeople.join("");
};

export { getUsers };