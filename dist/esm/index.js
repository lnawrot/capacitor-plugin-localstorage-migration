import { registerPlugin } from '@capacitor/core';
const LocalStorageMigrator = registerPlugin('LocalStorageMigrator', {
    web: () => import('./web').then(m => new m.LocalStorageMigratorWeb()),
});
export * from './definitions';
export { LocalStorageMigrator };
//# sourceMappingURL=index.js.map