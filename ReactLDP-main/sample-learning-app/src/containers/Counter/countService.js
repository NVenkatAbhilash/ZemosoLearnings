export const incrementCount = () => {
  return new Promise((resolve) =>
    setTimeout(() => {
      resolve();
    }, 1000)
  );
};