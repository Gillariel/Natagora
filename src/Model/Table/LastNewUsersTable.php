<?php
namespace App\Model\Table;

use Cake\ORM\Query;
use Cake\ORM\RulesChecker;
use Cake\ORM\Table;
use Cake\Validation\Validator;

/**
 * LastNewUsers Model
 *
 * @method \App\Model\Entity\LastNewUser get($primaryKey, $options = [])
 * @method \App\Model\Entity\LastNewUser newEntity($data = null, array $options = [])
 * @method \App\Model\Entity\LastNewUser[] newEntities(array $data, array $options = [])
 * @method \App\Model\Entity\LastNewUser|bool save(\Cake\Datasource\EntityInterface $entity, $options = [])
 * @method \App\Model\Entity\LastNewUser patchEntity(\Cake\Datasource\EntityInterface $entity, array $data, array $options = [])
 * @method \App\Model\Entity\LastNewUser[] patchEntities($entities, array $data, array $options = [])
 * @method \App\Model\Entity\LastNewUser findOrCreate($search, callable $callback = null, $options = [])
 */
class LastNewUsersTable extends Table
{

    /**
     * Initialize method
     *
     * @param array $config The configuration for the Table.
     * @return void
     */
    public function initialize(array $config)
    {
        parent::initialize($config);

        $this->setTable('last_new_users');
    }

    /**
     * Default validation rules.
     *
     * @param \Cake\Validation\Validator $validator Validator instance.
     * @return \Cake\Validation\Validator
     */
    public function validationDefault(Validator $validator)
    {
        $validator
            ->requirePresence('Number', 'create')
            ->notEmpty('Number');

        return $validator;
    }
}
